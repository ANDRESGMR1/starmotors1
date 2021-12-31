package com.grupo3.Caso1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CaracteristicaVehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_caracteristica;	
	private String seguridad;
	private String tecnologia;
	private int velocidades;
	private String interior;
	private String rines;
	private int cilindros;
	private String direccion;
	private String capacidad_carga;
	private String vidrios;
	private int numero_de_puertas;
	private String motor;
	
	public CaracteristicaVehiculo(Long id_caracteristica, String seguridad, String tecnologia, int velocidades,
			String interior, String rines, int cilindros, String direccion, String capacidad_carga, String vidrios,
			int numero_de_puertas, String motor) {
		
		this.id_caracteristica = id_caracteristica;
		this.seguridad = seguridad;
		this.tecnologia = tecnologia;
		this.velocidades = velocidades;
		this.interior = interior;
		this.rines = rines;
		this.cilindros = cilindros;
		this.direccion = direccion;
		this.capacidad_carga = capacidad_carga;
		this.vidrios = vidrios;
		this.numero_de_puertas = numero_de_puertas;
		this.motor = motor;
	}
	public CaracteristicaVehiculo() {
		
	}
	public Long getId_caracteristica() {
		return id_caracteristica;
	}
	public void setId_caracteristica(Long id_caracteristica) {
		this.id_caracteristica = id_caracteristica;
	}
	public String getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public int getVelocidades() {
		return velocidades;
	}
	public void setVelocidades(int velocidades) {
		this.velocidades = velocidades;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	public String getRines() {
		return rines;
	}
	public void setRines(String rines) {
		this.rines = rines;
	}
	public int getCilindros() {
		return cilindros;
	}
	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCapacidad_carga() {
		return capacidad_carga;
	}
	public void setCapacidad_carga(String capacidad_carga) {
		this.capacidad_carga = capacidad_carga;
	}
	public String getVidrios() {
		return vidrios;
	}
	public void setVidrios(String vidrios) {
		this.vidrios = vidrios;
	}
	public int getNumero_de_puertas() {
		return numero_de_puertas;
	}
	public void setNumero_de_puertas(int numero_de_puertas) {
		this.numero_de_puertas = numero_de_puertas;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}

}
