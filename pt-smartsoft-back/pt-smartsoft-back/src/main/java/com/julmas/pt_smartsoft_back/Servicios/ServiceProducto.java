package com.julmas.pt_smartsoft_back.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julmas.pt_smartsoft_back.Modelos.Producto;
import com.julmas.pt_smartsoft_back.Repositorios.IProductoRepo;
import com.julmas.pt_smartsoft_back.Excepciones.GlobalExceptionNotFound;


@Service
public class ServiceProducto implements IServiceProducto{

    @Autowired
    private IProductoRepo productoRepository;
    @Override
    public Producto registrarProducto(Producto producto) {
        this.productoRepository.save(producto);
        return producto;
    }

    @Override
    public void eliminarProducto(Integer id_producto) {
        this.productoRepository.deleteById(id_producto);
        
    }

    @Override
    public Producto mostrarProducto(Integer id_producto) {
        return this.productoRepository.findById(id_producto)
                .orElseThrow(() -> new GlobalExceptionNotFound("Producto ", String.valueOf(id_producto)));
    }

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepository.findAll();    
    }

}
