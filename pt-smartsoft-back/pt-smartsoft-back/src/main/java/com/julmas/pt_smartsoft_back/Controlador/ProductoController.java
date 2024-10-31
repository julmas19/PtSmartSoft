package com.julmas.pt_smartsoft_back.Controlador;

import java.util.List;

import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julmas.pt_smartsoft_back.Excepciones.GlobalExceptionNotFound;
import com.julmas.pt_smartsoft_back.Modelos.Producto;
import com.julmas.pt_smartsoft_back.Servicios.ServiceProducto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("productos")
@CrossOrigin
public class ProductoController {
    @Autowired
    private ServiceProducto productoService;

    //private Map<String, Object> errorBody = new HashMap<>();
    private Map<String, Object> respuesta = new HashMap<>();

    @GetMapping("/listar")
    public List<Producto> listarProductos() {
        List<Producto> productos = this.productoService.listarProductos();
        return productos;
    }

    //Buscar un solo producto
    @GetMapping("/buscar/{id_producto}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id_producto){
        Producto producto = this.productoService.mostrarProducto(id_producto);
        if (producto!=null) {
            System.out.println(String.format("Producto %s consultado correctamente\n", producto.getId_producto()));

            return ResponseEntity.ok(producto);
        }
        else
        throw new GlobalExceptionNotFound("Producto ", String.valueOf(id_producto));

    }

    
    //Registrar nuevo producto
    @PostMapping("registro")
    public ResponseEntity<Map<String, Object>> registrarProducto(@RequestBody Producto producto) {
        
        Producto nuevoProducto = productoService.registrarProducto(producto);
        System.out.println(String.format("Producto %s Creado correctamente\n", nuevoProducto.getId_producto()));
        respuesta.put("mensaje", "Producto creado exitosamente");
        respuesta.put("id_producto", nuevoProducto.getId_producto());
        respuesta.put("nombre", nuevoProducto.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    //Eliminar un producto
    @DeleteMapping("/eliminar/{id_producto}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Integer id_producto){
        Producto producto = productoService.mostrarProducto(id_producto);
        if (producto!=null) {
            this.productoService.eliminarProducto(producto.getId_producto());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Producto eliminado", Boolean.TRUE);
            System.out.println(String.format("Producto %s eliminado correctamente\n", producto.getId_producto()));
            return ResponseEntity.ok(respuesta);
        }
        else
        throw new GlobalExceptionNotFound("Producto ", String.valueOf(id_producto));
        


    }
    
}
