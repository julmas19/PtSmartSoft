package com.julmas.pt_smartsoft_back.Servicios;

import java.util.List;
import com.julmas.pt_smartsoft_back.Modelos.Cliente;

public interface IServiceCliente {
    
    //Registrar Datos de los clientes
    public Cliente registrarCliente(Cliente cliente);
    
    //Eliminar Datos de los clientes por identidicacion
    public void eliminarCliente(Long id_cliente);
    
    //Consulta un solo cliente por identificacion
    public Cliente buscarCliente(Long id_cliente);
    
    //Consulta todos los Clientes
    public List<Cliente> listarClientes();


}
