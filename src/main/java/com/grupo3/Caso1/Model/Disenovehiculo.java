package com.grupo3.Caso1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disenovehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_diseno;
	private String marca;
	private String modelo;
	
	public Disenovehiculo(Long id_diseno, String marca, String modelo) {
		
		this.id_diseno = id_diseno;
		this.marca = marca;
		this.modelo = modelo;
	}
	public Disenovehiculo() {
		
	}
	public Long getId_diseno() {
		return id_diseno;
	}
	public void setId_diseno(Long id_diseno) {
		this.id_diseno = id_diseno;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
