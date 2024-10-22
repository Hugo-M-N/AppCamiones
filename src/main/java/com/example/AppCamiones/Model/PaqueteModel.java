package com.example.AppCamiones.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PAQUETE")
public class PaqueteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaquete;
	
	@Column(name="codigo_paquete")
	private String codigoPaquete;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="destino")
	private String destino;
	
	@ManyToOne
	@JoinColumn(name="id_camionero")
	private CamioneroModel camionero;
	
	public CiudadModel getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(CiudadModel ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	@ManyToOne
	@JoinColumn(name="idCiudad")
	private CiudadModel ciudadDestino;

	public CamioneroModel getCamionero() {
		return camionero;
	}

	public void setCamionero(CamioneroModel camionero) {
		this.camionero = camionero;
	}

	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}

	public String getCodigoPaquete() {
		return codigoPaquete;
	}

	public void setCodigoPaquete(String codigoPaquete) {
		this.codigoPaquete = codigoPaquete;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}
