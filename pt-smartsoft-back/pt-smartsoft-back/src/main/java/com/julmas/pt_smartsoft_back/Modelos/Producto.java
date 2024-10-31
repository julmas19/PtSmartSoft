package com.julmas.pt_smartsoft_back.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_producto;
	String nombre;
    Double precio;
    Integer stock;

    public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}

