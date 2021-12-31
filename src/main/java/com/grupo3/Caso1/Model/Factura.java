package com.grupo3.Caso1.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_emision;

	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private String ruc_factura;

	@Column(nullable = false)
	private String nombre_empresa;

	@Column(nullable = false)
	private String direccion;

	 @JsonIgnoreProperties(value={"facturas", "hibernateLazyInitializer",
	 "handler"}, allowSetters=true)
	 @ManyToOne(fetch = FetchType.LAZY)
	 private Client cliente;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "factura_id")
	private List<DetalleFactura> detallesfacturas;

	public Factura() {
		this.detallesfacturas = new ArrayList<>();
	}

	@PrePersist
	public void prepersist() {
		this.fecha_emision = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuc_factura() {
		return ruc_factura;
	}

	public void setRuc_factura(String ruc_factura) {
		this.ruc_factura = ruc_factura;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<DetalleFactura> getDetallesfacturas() {
		return detallesfacturas;
	}

	public void setDetallesfacturas(List<DetalleFactura> detallesfacturas) {
		this.detallesfacturas = detallesfacturas;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	
	  public Double getTotal() {
	  Double total=0.00;
	  for(DetalleFactura detalles:detallesfacturas) {
	  total += detalles.getTotal();
	  }
	  return total;
	  }
	 

}
