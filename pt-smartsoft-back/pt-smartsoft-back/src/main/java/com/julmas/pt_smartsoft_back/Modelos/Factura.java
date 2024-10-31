package com.julmas.pt_smartsoft_back.Modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@ToString
@Data
@AllArgsConstructor
@Table(name="Facturas")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer num_factura;
  //Relacion de muchos a uno con la tabla clientes
    //@JsonIncludeProperties()
    @JsonIncludeProperties({"id_cliente","nombre"})
    @ManyToOne
    @JoinColumn(name="id_cliente", nullable = false)
    Cliente cliente;

    @Column(nullable = false, updatable = false)
    LocalDateTime fecha;

    @JsonIncludeProperties("num_detalle")
    @OneToMany(mappedBy = "factura", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Detalle> detalle;

    // Constructor sin parámetros
    public Factura(){
        this.fecha = LocalDateTime.now(); // Establece la fecha actual
    }
    
    
    public Integer getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(Integer num_factura) {
		this.num_factura = num_factura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	
    
}

