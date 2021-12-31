package com.grupo3.Caso1.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InformeReclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idinformeRecha;
    private Date fechaEmicion;
    private String respuestaCliente;
    private String tipoInforme;
    @ManyToOne
    @JoinColumn(name = "cedulaClient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_reclamo")
    private ReclamoGarantia reclamogarantia;

    private String descripcionInforme;

    public InformeReclamo() {
    }

    public InformeReclamo(Long idinformeRecha, Date fechaEmicion, String respuestaCliente, String tipoInforme,
            Client client, ReclamoGarantia reclamogarantia, String descripcionInforme) {
        this.idinformeRecha = idinformeRecha;
        this.fechaEmicion = fechaEmicion;
        this.respuestaCliente = respuestaCliente;
        this.tipoInforme = tipoInforme;
        this.client = client;
        this.reclamogarantia = reclamogarantia;
        this.descripcionInforme = descripcionInforme;
    }

    public String getRespuestaCliente() {
        return respuestaCliente;
    }

    public void setRespuestaCliente(String respuestaCliente) {
        this.respuestaCliente = respuestaCliente;
    }

    public ReclamoGarantia getReclamogarantia() {
        return reclamogarantia;
    }

    public void setReclamogarantia(ReclamoGarantia reclamogarantia) {
        this.reclamogarantia = reclamogarantia;
    }

    public String getTipoInforme() {
        return tipoInforme;
    }

    public void setTipoInforme(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    public Long getIdinformeRecha() {
        return idinformeRecha;
    }

    public void setIdinformeRecha(Long idinformeRecha) {
        this.idinformeRecha = idinformeRecha;
    }

    public Date getFechaEmicion() {
        return fechaEmicion;
    }

    public void setFechaEmicion(Date fechaEmicion) {
        this.fechaEmicion = fechaEmicion;
    }

    public String getDescripcionInforme() {
        return descripcionInforme;
    }

    public void setDescripcionInforme(String descripcionInforme) {
        this.descripcionInforme = descripcionInforme;
    }

    public String isTipo_informe() {
        return tipoInforme;
    }

    public void setTipo_informe(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
