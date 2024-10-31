package com.julmas.pt_smartsoft_back.Servicios;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julmas.pt_smartsoft_back.Modelos.Cliente;
import com.julmas.pt_smartsoft_back.Repositorios.IClienteRepo;



@Service
public class ServiceCliente implements IServiceCliente{
    @Autowired
    private IClienteRepo clienteRepository;

    //Guarda la informacion de un cliente
    @Override
    public Cliente registrarCliente(Cliente cliente) {
        
        this.clienteRepository.save(cliente);
        return cliente;
        
    }

    //Eliminar un cliente
    @Override
    public void eliminarCliente(Long id_cliente) {
        this.clienteRepository.deleteById(String.valueOf(id_cliente));
    }

    //Muestra la informacion de un solo cliente
    @Override
    public Cliente buscarCliente(Long id_cliente) {
        return this.clienteRepository.findById(String.valueOf(id_cliente)).orElse(null);
    }

    
    //Mostrar la informacion de todos los clientes
    @Override
    public List<Cliente> listarClientes() {
        return this.clienteRepository.findAll();

    }   
}
