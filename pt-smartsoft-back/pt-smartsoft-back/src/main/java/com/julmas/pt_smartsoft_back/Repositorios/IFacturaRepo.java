package com.julmas.pt_smartsoft_back.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.julmas.pt_smartsoft_back.Modelos.Factura;

public interface IFacturaRepo extends JpaRepository<Factura,Integer> {


}
