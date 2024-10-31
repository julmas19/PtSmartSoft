package com.julmas.pt_smartsoft_back.Servicios;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.julmas.pt_smartsoft_back.Modelos.Detalle;

public interface IServiceDetalle {

    //Registra una nueva detalle
    public Detalle registrarDetalle(Integer id_factura,JsonNode detalle);

    //Consulta una detalle por Id
    public Detalle consultarDetalle(Integer num_detalle);
    
    //Consulta todos los detalles
    public List<Detalle> listarDetalles(); 
    
    //Eliminar una detalle
    public void eliminarDetalle(Integer num_detalle);
}
