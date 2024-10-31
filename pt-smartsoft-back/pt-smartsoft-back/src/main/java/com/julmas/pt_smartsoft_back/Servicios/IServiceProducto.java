package com.julmas.pt_smartsoft_back.Servicios;

import java.util.List;
import com.julmas.pt_smartsoft_back.Modelos.Producto;

public interface IServiceProducto {

    //Registrar Datos de productos
    public Producto registrarProducto(Producto producto);
    
    //Eliminar Datos de productos
    public void eliminarProducto(Integer id_producto);
    
    //Consulta un solo producto por id
    public Producto mostrarProducto(Integer id_producto);
    
    //Consulta todos los productos
    public List<Producto> listarProductos();
}
