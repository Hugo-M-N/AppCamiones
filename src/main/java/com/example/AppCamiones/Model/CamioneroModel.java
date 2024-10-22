package com.example.AppCamiones.Model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CAMIONERO")
public class CamioneroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCamionero;
	
	@Column(name="DNI")
	private String dni;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Telefono")
	private String telefono;
	
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="Salario")
	private Double salario;
	
	@OneToMany(mappedBy = "camionero")
	private List<PaqueteModel> paquetes;
	
	@OneToMany(mappedBy = "camionero")
	private List<ViajeModel> viajes;

	public List<ViajeModel> getViajes() {
		return viajes;
	}

	public void setViajes(List<ViajeModel> viajes) {
		this.viajes = viajes;
	}

	public List<PaqueteModel> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<PaqueteModel> paquetes) {
		this.paquetes = paquetes;
	}

	public Integer getIdCamionero() {
		return idCamionero;
	}

	public void setIdCamionero(Integer idCamionero) {
		this.idCamionero = idCamionero;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
}
