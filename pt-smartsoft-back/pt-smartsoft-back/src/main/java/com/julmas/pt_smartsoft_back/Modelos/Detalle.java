package com.julmas.pt_smartsoft_back.Modelos;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="Detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer num_detalle;
    //Fora

	@JsonIncludeProperties({"num_factura","cliente"})
    @ManyToOne
    @JoinColumn(name="id_factura", nullable = false)
    Factura factura;
    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false)
    Producto producto;
    Integer cantidad;
    Double precio;
    
    
    
    public Integer getNum_detalle() {
		return num_detalle;
	}
	public void setNum_detalle(Integer num_detalle) {
		this.num_detalle = num_detalle;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	

    
}
