package com.julmas.pt_smartsoft_back.Modelos;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Clientes")
public class Cliente {
    @Id
    Long id_cliente;
    String nombre;
    String apellido;
    String direccion;
    LocalDate fecha_nacimiento;
    Long telefono;
    String email;
  //Relacion para eliminar facturas asociadas cuando se elimine un cliente
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Factura> facturas;
    
    public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

    

}
