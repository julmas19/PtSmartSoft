package com.julmas.pt_smartsoft_back.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julmas.pt_smartsoft_back.Modelos.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente,String>{

}
