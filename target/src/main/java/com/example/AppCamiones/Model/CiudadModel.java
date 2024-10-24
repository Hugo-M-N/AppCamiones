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
@Table(name="CIUDAD")
public class CiudadModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCiudad;
	
	@Column(name="codigo_ciudad")
	private String codigoCiudad;
	
	@Column(name="nombre_ciudad")
	private String nombreCiudad;
	
	public List<PaqueteModel> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<PaqueteModel> paquetes) {
		this.paquetes = paquetes;
	}

	@OneToMany(mappedBy = "ciudadDestino")
	private List<PaqueteModel> paquetes;

	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	
	
}
