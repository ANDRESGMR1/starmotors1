package com.grupo3.Caso1.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GarantiaVehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGarantia;
	private String descripcion;
	@Column(name = "estado", columnDefinition = "boolean DEFAULT 'true'")
	private boolean estado;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_garantia")
	private  List<DetalleGarantia> detallegarantia;
	

	public GarantiaVehiculo() {
		// TODO Auto-generated constructor stub
	}


	public GarantiaVehiculo(Long idGarantia, String descripcion, List<DetalleGarantia> detallegarantia,boolean estado) {
		this.idGarantia = idGarantia;
		this.descripcion = descripcion;
		this.detallegarantia = detallegarantia;
		this.estado=estado;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Long getIdGarantia() {
		return idGarantia;
	}


	public void setIdGarantia(Long idGarantia) {
		this.idGarantia = idGarantia;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<DetalleGarantia> getDetallegarantia() {
		return detallegarantia;
	}


	public void setDetallegarantia(List<DetalleGarantia> detallegarantia) {
		this.detallegarantia = detallegarantia;
	}
	
	
	}
