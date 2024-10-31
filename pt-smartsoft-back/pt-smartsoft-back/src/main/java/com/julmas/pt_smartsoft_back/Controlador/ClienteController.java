package com.julmas.pt_smartsoft_back.Controlador;
import java.util.List;

import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julmas.pt_smartsoft_back.Excepciones.GlobalExceptionNotFound;
import com.julmas.pt_smartsoft_back.Modelos.Cliente;
import com.julmas.pt_smartsoft_back.Servicios.ServiceCliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("clientes")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ServiceCliente clienteService;
    private Map<String, Object> errorBody = new HashMap<>();
    private Map<String, Object> respuesta = new HashMap<>();
    //http://127.0.0.1:8080/cliente/
    //Listar todos los clientes
    @GetMapping("/listar")
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = this.clienteService.listarClientes();
        return clientes;
    }

    //Buscar un solo cliente
    @GetMapping("/buscar/{id_cliente}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id_cliente){
        Cliente cliente = this.clienteService.buscarCliente(id_cliente);
        if (cliente!=null) {
            System.out.println(String.format("Cliente %s consultado correctamente\n", cliente.getId_cliente()));

            return ResponseEntity.ok(cliente);
        }
        else
        throw new GlobalExceptionNotFound("Cliente ", String.valueOf(id_cliente));

    }
    
    //Registrar nuevo cliente
    @PostMapping("/registro")
    public ResponseEntity<Map<String, Object>> registrarCliente(@RequestBody Cliente cliente) {

        //Validamos si ya existe el cliente
        if(this.clienteService.buscarCliente(cliente.getId_cliente())!=null){
            errorBody.put("error", "Conflicto");
            errorBody.put("mensaje", "Ya existe un cliente con el ID: " + cliente.getId_cliente());
            errorBody.put("status", HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorBody);
        }

        Cliente nuevoCliente = clienteService.registrarCliente(cliente);
        
        System.out.println(String.format("Cliente %s Creado correctamente\n", nuevoCliente.getId_cliente()));

        respuesta.put("mensaje", "Cliente creado exitosamente");
        respuesta.put("id_cliente", nuevoCliente.getId_cliente());
        respuesta.put("nombre", nuevoCliente.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        
    }

    //Eliminar un cliente
    @DeleteMapping("/eliminar/{id_cliente}")
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Long id_cliente){
        Cliente cliente = clienteService.buscarCliente(id_cliente);
        if (cliente!=null) {
            this.clienteService.eliminarCliente(cliente.getId_cliente());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Cliente eliminado", Boolean.TRUE);
            System.out.println(String.format("Cliente %s eliminado correctamente\n", cliente.getId_cliente()));
            return ResponseEntity.ok(respuesta);
        }
        else
        throw new GlobalExceptionNotFound("Cliente ", String.valueOf(id_cliente));
        


    }
    
}
