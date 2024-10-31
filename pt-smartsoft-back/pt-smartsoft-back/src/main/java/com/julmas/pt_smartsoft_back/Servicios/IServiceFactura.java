package com.julmas.pt_smartsoft_back.Servicios;


//import com.julmas.pt_smartsoft_back.Modelos.Cliente;
import com.julmas.pt_smartsoft_back.Modelos.Factura;
import java.util.List;



public interface IServiceFactura {
   
    //Registra una nueva factura
    public Factura registrarFactura(String cliente_id);

    //Consulta una factura por Id
    public Factura consultarFactura(Integer id_factura);
    
    //Consulta todas las facturas
    public List<Factura> listarFacturas(); 
    //Eliminar una factura
    public void eliminarFactura(Integer id_factura);
}
