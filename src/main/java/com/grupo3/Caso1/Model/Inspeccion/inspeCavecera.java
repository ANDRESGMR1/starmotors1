package com.grupo3.Caso1.Model.Inspeccion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.grupo3.Caso1.Model.InformeReclamo;

@Entity
public class inspeCavecera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idinspeccionCavecera;
    private Date fecha_insepeccion;
    @ManyToOne
    @JoinColumn(name = "idinformeRecha")
    private InformeReclamo informeReclamo;

    public inspeCavecera() {
    }

    public inspeCavecera(Long idinspeccionCavecera, Date fecha_insepeccion) {
        this.idinspeccionCavecera = idinspeccionCavecera;
        this.fecha_insepeccion = fecha_insepeccion;
    }

    public Long getIdinspeccionCavecera() {
        return idinspeccionCavecera;
    }

    public void setIdinspeccionCavecera(Long idinspeccionCavecera) {
        this.idinspeccionCavecera = idinspeccionCavecera;
    }

    public Date getFecha_insepeccion() {
        return fecha_insepeccion;
    }

    public void setFecha_insepeccion(Date fecha_insepeccion) {
        this.fecha_insepeccion = fecha_insepeccion;
    }

    public InformeReclamo getInformeReclamo() {
        return informeReclamo;
    }

    public void setInformeReclamo(InformeReclamo informeReclamo) {
        this.informeReclamo = informeReclamo;
    }
}
