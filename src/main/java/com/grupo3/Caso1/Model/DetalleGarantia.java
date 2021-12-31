package com.grupo3.Caso1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DetalleGarantia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDetalle;
	private String cobertura;
	private String perido;

	public DetalleGarantia() {

		// TODO Auto-generated constructor stub
	}

	public DetalleGarantia(Long idDetalle, String cobertura, String perido) {
		this.idDetalle = idDetalle;
		this.cobertura = cobertura;
		this.perido = perido;
	}

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getPerido() {
		return perido;
	}

	public void setPerido(String perido) {
		this.perido = perido;
	}

}
