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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Reclamogarantia")
public class ReclamoGarantia implements Serializable{
	
	private static final long serialVersionUID = 7070756308733014404L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_reclamo;
	@OneToOne
	@JoinColumn(name = "fk_id_solicitud")
	private SolicitudGarantia fk_id_solicitud;
	@Temporal(TemporalType.DATE)
	private Date fecha_reclamo;
	@Column(columnDefinition = "boolean DEFAULT 'true'")
	private boolean estado_reclamo;
	
	@PrePersist
	public void prePersist() {
		fecha_reclamo = new Date();
	}

	public ReclamoGarantia(SolicitudGarantia fk_id_solicitud, Date fecha_reclamo, boolean estado_reclamo) {
		super();
		this.fk_id_solicitud = fk_id_solicitud;
		this.fecha_reclamo = fecha_reclamo;
		this.estado_reclamo = estado_reclamo;
	}


	public ReclamoGarantia() {
		super();
	}


	public Long getId_reclamo() {
		return id_reclamo;
	}


	public void setId_reclamo(Long id_reclamo) {
		this.id_reclamo = id_reclamo;
	}


	public SolicitudGarantia getFk_id_solicitud() {
		return fk_id_solicitud;
	}


	public void setFk_id_solicitud(SolicitudGarantia fk_id_solicitud) {
		this.fk_id_solicitud = fk_id_solicitud;
	}


	public Date getFecha_reclamo() {
		return fecha_reclamo;
	}


	public void setFecha_reclamo(Date fecha_reclamo) {
		this.fecha_reclamo = fecha_reclamo;
	}


	public boolean isEstado_reclamo() {
		return estado_reclamo;
	}


	public void setEstado_reclamo(boolean estado_reclamo) {
		this.estado_reclamo = estado_reclamo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
