package com.example.AppCamiones.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CAMION")
public class CamionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCamion;
	
	private String matricula;
	
	private String modelo;
	
	private Double km;
	
	@OneToMany(mappedBy="camion")
	private List<ViajeModel> viaje;

	public Integer getIdCamion() {
		return idCamion;
	}

	public void setIdCamion(Integer idCamion) {
		this.idCamion = idCamion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public List<ViajeModel> getViaje() {
		return viaje;
	}

	public void setViaje(List<ViajeModel> viaje) {
		this.viaje = viaje;
	}
	
	
}
