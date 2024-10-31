package com.julmas.pt_smartsoft_back.Servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.julmas.pt_smartsoft_back.Excepciones.GlobalExceptionNotFound;
import com.julmas.pt_smartsoft_back.Modelos.Detalle;
import com.julmas.pt_smartsoft_back.Modelos.Factura;
import com.julmas.pt_smartsoft_back.Modelos.Producto;
import com.julmas.pt_smartsoft_back.Repositorios.IDetalleRepo;
import com.julmas.pt_smartsoft_back.Repositorios.IFacturaRepo;
import com.julmas.pt_smartsoft_back.Repositorios.IProductoRepo;


@Service
public class ServiceDetalle implements IServiceDetalle{

    private final IFacturaRepo facturaRepository;
    private final IProductoRepo productoRepository;
    private final IDetalleRepo detalleRepository;



   // @Autowired
    public ServiceDetalle(IFacturaRepo facturaRepository, IProductoRepo productoRepository, IDetalleRepo detalleRepository) {
        this.facturaRepository = facturaRepository;
        this.productoRepository = productoRepository;
        this.detalleRepository = detalleRepository;
    }
    @Override
    public Detalle registrarDetalle(Integer id_factura, JsonNode detalleBody) {
        Factura factura = facturaRepository.findById(id_factura)
                .orElseThrow(() -> new GlobalExceptionNotFound("Factura ", String.valueOf(id_factura)));

        Integer id_producto = detalleBody.path("producto").path("id_producto").asInt();
        Integer cantidad = detalleBody.get("cantidad").asInt();

        Producto producto = productoRepository.findById(id_producto)
                .orElseThrow(() -> new GlobalExceptionNotFound("Producto ", String.valueOf(id_producto)));
                
        Detalle detalle = new Detalle();
        
        detalle.setFactura(factura);
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setPrecio(producto.getPrecio());
        
        
        return detalleRepository.save(detalle);
    }

    @Override
    public Detalle consultarDetalle(Integer num_detalle) {
        return this.detalleRepository.findById(num_detalle).orElse(null);
    }

    @Override
    public List<Detalle> listarDetalles() {
        return this.detalleRepository.findAll();

    }
    
    

    @Override
    public void eliminarDetalle(Integer num_detalle) {
        Detalle detalle = detalleRepository.findById(num_detalle)
                .orElseThrow(() -> new GlobalExceptionNotFound("Factura ", String.valueOf(num_detalle)));
        this.detalleRepository.deleteById(detalle.getNum_detalle());
    }

}
