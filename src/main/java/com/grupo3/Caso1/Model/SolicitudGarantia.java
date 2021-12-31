package com.grupo3.Caso1.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "solicitudgarantia")
public class SolicitudGarantia implements Serializable {

	private static final long serialVersionUID = -4205639510532965379L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_solicitud;
	@Temporal(TemporalType.DATE)
	private Date fecha_solicitud;
	@OneToOne
	@JoinColumn(name = "chasis")
	private Vehiculo fk_chasis_vehiculo;
	private String descripcion;
	@Column(name = "estado_solicitud", columnDefinition = "boolean DEFAULT 'true'")
	private boolean estado_solicitud;

	public SolicitudGarantia() {
		super();
	}

	public SolicitudGarantia(Date fecha_solicitud, Vehiculo fk_chasis_vehiculo, String descripcion,
			boolean estado_solicitud) {
		super();
		this.fecha_solicitud = fecha_solicitud;
		this.fk_chasis_vehiculo = fk_chasis_vehiculo;
		this.descripcion = descripcion;
		this.estado_solicitud = estado_solicitud;
	}

	public Long getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Long id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public Vehiculo getFk_chasis_vehiculo() {
		return fk_chasis_vehiculo;
	}

	public void setFk_chasis_vehiculo(Vehiculo fk_chasis_vehiculo) {
		this.fk_chasis_vehiculo = fk_chasis_vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado_solicitud() {
		return estado_solicitud;
	}

	public void setEstado_solicitud(boolean estado_solicitud) {
		this.estado_solicitud = estado_solicitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
