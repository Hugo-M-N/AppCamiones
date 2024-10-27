package com.example.AppCamiones.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VIAJE")
public class ViajeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idViaje;
	
	@ManyToOne
	@JoinColumn(name="id_camionero")
	private CamioneroModel camionero;
							
	@ManyToOne
	@JoinColumn(name="id_camion")
	private CamionModel camion;
	
	private Date fechaViaje;

	public Integer getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Integer idViaje) {
		this.idViaje = idViaje;
	}

	public CamioneroModel getCamionero() {
		return camionero;
	}

	public void setCamionero(CamioneroModel camionero) {
		this.camionero = camionero;
	}

	public CamionModel getCamion() {
		return camion;
	}

	public void setCamion(CamionModel camion) {
		this.camion = camion;
	}

	public Date getFechaViaje() {
		return fechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}
}
