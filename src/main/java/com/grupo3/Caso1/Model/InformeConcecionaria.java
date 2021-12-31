package com.grupo3.Caso1.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.grupo3.Caso1.Model.ordenReparacion.DetalleRepuestos;
import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCuerpo;

@Entity
public class InformeConcecionaria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConcesionaria;
	private String descricion;
	private int porcentaje;
	@Column(name = "estado", columnDefinition = "boolean DEFAULT 'true'")
	private boolean estado;
	@OneToOne 
	private ordenRepCuerpo detalle;
	private double total;
	private Date fecha;
	
	
	
	
	public InformeConcecionaria(Long idConcesionaria, String descricion, int porcentaje, boolean estado,
			ordenRepCuerpo detalle, double total, Date fecha) {
		this.idConcesionaria = idConcesionaria;
		this.descricion = descricion;
		this.porcentaje = porcentaje;
		this.estado = estado;
		this.detalle = detalle;
		this.total = total;
		this.fecha = fecha;
	}
	
	
	public InformeConcecionaria() {
		// TODO Auto-generated constructor stub
	}


	public Long getIdConcesionaria() {
		return idConcesionaria;
	}
	public void setIdConcesionaria(Long idConcesionaria) {
		this.idConcesionaria = idConcesionaria;
	}
	public String getDescricion() {
		return descricion;
	}
	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public ordenRepCuerpo getDetalle() {
		return detalle;
	}
	public void setDetalle(ordenRepCuerpo detalle) {
		this.detalle = detalle;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	
}
