package com.julmas.pt_smartsoft_back.Servicios;

import com.julmas.pt_smartsoft_back.Excepciones.GlobalExceptionNotFound;
import com.julmas.pt_smartsoft_back.Modelos.Cliente;
import com.julmas.pt_smartsoft_back.Modelos.Factura;

import java.util.List;



//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julmas.pt_smartsoft_back.Repositorios.IClienteRepo;
import com.julmas.pt_smartsoft_back.Repositorios.IDetalleRepo;
import com.julmas.pt_smartsoft_back.Repositorios.IFacturaRepo;

@Service
public class ServiceFactura implements IServiceFactura{
    private final IFacturaRepo facturaRepository;
    private final IClienteRepo clienteRepository;

   // @Autowired
    public ServiceFactura(IFacturaRepo facturaRepository, IClienteRepo clienteRepository, IDetalleRepo detalleRepository) {
        this.facturaRepository = facturaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Factura registrarFactura(String id_cliente) {

        Cliente cliente = clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new GlobalExceptionNotFound("Cliente ", String.valueOf(id_cliente)));
        Factura factura = new Factura(); 
        factura.setCliente(cliente);
        
        return facturaRepository.save(factura);

    }

    @Override
    public Factura consultarFactura(Integer id_factura) {
        return this.facturaRepository.findById(id_factura).orElse(null);
    }


    @Override
    public List<Factura> listarFacturas() {
        return this.facturaRepository.findAll();
        
    }

    @Override
    public void eliminarFactura(Integer id_factura) {
        Factura factura = facturaRepository.findById(id_factura)
                .orElseThrow(() -> new GlobalExceptionNotFound("Factura ", String.valueOf(id_factura)));
        this.facturaRepository.deleteById(factura.getNum_factura());
    }

  

}
