package com.julmas.pt_smartsoft_back.Controlador;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.julmas.pt_smartsoft_back.Modelos.Detalle;
import com.julmas.pt_smartsoft_back.Servicios.ServiceDetalle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/detalles")
@CrossOrigin
public class DetalleController {
    @Autowired
    ServiceDetalle detalleService;
    
    @GetMapping("/listar")
    public List<Detalle> listarFacturas(){
        List<Detalle> detalles = this.detalleService.listarDetalles();
        return detalles;
    }
    

    @PostMapping("/registro")
    public ResponseEntity<Detalle> crearDetalle(@RequestParam Integer num_factura, @RequestBody JsonNode detalle) {
        Detalle detalles = detalleService.registrarDetalle(num_factura, detalle);
        return ResponseEntity.ok(detalles);
    }   
    
}
