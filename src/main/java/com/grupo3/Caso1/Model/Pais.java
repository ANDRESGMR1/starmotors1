package com.grupo3.Caso1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPais;
	private String nombre;
	
	public Pais() {
		// TODO Auto-generated constructor stub
	}

	public Pais(Long idPais, String nombre) {
		this.idPais = idPais;
		this.nombre = nombre;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
