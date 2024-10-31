package com.julmas.pt_smartsoft_back.Controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.julmas.pt_smartsoft_back.Modelos.Detalle;
import com.julmas.pt_smartsoft_back.Modelos.Factura;
import com.julmas.pt_smartsoft_back.Servicios.ServiceCliente;
//import com.julmas.pt_smartsoft_back.Modelos.Producto;
import com.julmas.pt_smartsoft_back.Servicios.ServiceFactura;

import java.util.List;



@RestController
@RequestMapping("/facturas")
@CrossOrigin
public class FacturaController {

    @Autowired
    ServiceFactura facturaService;
    ServiceCliente clienteService;
    
    @GetMapping("/listar")
    public List<Factura> listarFacturas(){
        List<Factura> facturas = this.facturaService.listarFacturas();
        return facturas;
    }

    @PostMapping("/registro")
    public ResponseEntity<Factura> crearFactura(@RequestParam String id_cliente) {
        Factura factura = facturaService.registrarFactura(id_cliente);
        return ResponseEntity.ok(factura);
    }

    



}
