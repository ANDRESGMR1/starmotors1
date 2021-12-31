package com.grupo3.Caso1.Model;

public class ConcecionariaInforme {
	private int id;
	private double precio;
	private double mano_obra;
	
	
	
	public ConcecionariaInforme() {
		// TODO Auto-generated constructor stub
	}
	public ConcecionariaInforme(int id, double precio, double mano_obra) {
		this.id = id;
		this.precio = precio;
		this.mano_obra = mano_obra;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getMano_obra() {
		return mano_obra;
	}
	public void setMano_obra(double mano_obra) {
		this.mano_obra = mano_obra;
	}


	
}
