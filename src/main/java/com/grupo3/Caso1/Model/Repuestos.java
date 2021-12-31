package com.grupo3.Caso1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grupo3.Caso1.Model.ordenReparacion.DetalleRepuestos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Repuestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_repuesto;
    private String nombre_repuesto;
    //private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_diseno")
    private Disenovehiculo diseno;


    private float precio;

    @OneToMany(mappedBy = "repuesto")
    @JsonIgnore
    private List<DetalleRepuestos> detalleRepuestos = new ArrayList<>();

    public Repuestos(Long id_repuesto, String nombre_repuesto, Disenovehiculo diseno, float precio/*, boolean estado*/) {

        this.id_repuesto = id_repuesto;
        this.nombre_repuesto = nombre_repuesto;
        this.diseno = diseno;
        this.precio = precio;
        //this.estado = estado;
    }

    public Repuestos() {
        super();
    }

    public Long getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(Long id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public String getNombre_repuesto() {
        return nombre_repuesto;
    }

    public void setNombre_repuesto(String nombre_repuesto) {
        this.nombre_repuesto = nombre_repuesto;
    }

    public Disenovehiculo getDiseno() {
        return diseno;
    }

    public void setDiseno(Disenovehiculo diseno) {
        this.diseno = diseno;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
/*
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }*/

    public List<DetalleRepuestos> getDetalleRepuestos() {
        return detalleRepuestos;
    }

    public void setDetalleRepuestos(List<DetalleRepuestos> detalleRepuestos) {
        this.detalleRepuestos = detalleRepuestos;
    }
}