package com.grupo3.Caso1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vehiculo_catalogo")
public class vehiculo_catalogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vehiculo_catalogo;	
	
	@ManyToOne
	@JoinColumn(name="id_diseno")
	private Disenovehiculo diseno;
	
	private int year_vehiculo;
	
	@ManyToOne
	@JoinColumn(name="id_caracteristica")
	private CaracteristicaVehiculo caracteristica;
	
	private String links_imagen;

	
	public vehiculo_catalogo(Long id_vehiculo_catalogo, Disenovehiculo diseno, int year_vehiculo,
			CaracteristicaVehiculo caracteristica, String links_imagen) {
		this.id_vehiculo_catalogo = id_vehiculo_catalogo;
		this.diseno = diseno;
		this.year_vehiculo = year_vehiculo;
		this.caracteristica = caracteristica;
		this.links_imagen = links_imagen;
	}

	public vehiculo_catalogo() {
	}

	public Long getId_vehiculo_catalogo() {
		return id_vehiculo_catalogo;
	}

	public void setId_vehiculo_catalogo(Long id_vehiculo_catalogo) {
		this.id_vehiculo_catalogo = id_vehiculo_catalogo;
	}

	public int getYear_vehiculo() {
		return year_vehiculo;
	}

	public void setYear_vehiculo(int year_vehiculo) {
		this.year_vehiculo = year_vehiculo;
	}

	public Disenovehiculo getDiseno() {
		return diseno;
	}

	public void setDiseno(Disenovehiculo id_diseno) {
		this.diseno = id_diseno;
	}

	public CaracteristicaVehiculo getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(CaracteristicaVehiculo id_caracteristica) {
		this.caracteristica = id_caracteristica;
	}

	public String getLinks_imagen() {
		return links_imagen;
	}

	public void setLinks_imagen(String links_imagen) {
		this.links_imagen = links_imagen;
	}	
}
