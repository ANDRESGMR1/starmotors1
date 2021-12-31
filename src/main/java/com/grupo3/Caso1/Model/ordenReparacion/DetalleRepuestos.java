package com.grupo3.Caso1.Model.ordenReparacion;

import com.grupo3.Caso1.Model.Repuestos;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_repuestos")
public class DetalleRepuestos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    @JsonIgnore
    private Repuestos repuesto;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    @JsonIgnore
    private ordenRepCuerpo orden;

    private String estado;

    public DetalleRepuestos() {
    }

    public DetalleRepuestos(Long id, String estado, Repuestos repuesto, ordenRepCuerpo orden) {
        this.id = id;
        this.estado = estado;
        this.repuesto = repuesto;
        this.orden = orden;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Repuestos getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuestos repuesto) {
        this.repuesto = repuesto;
    }

    public ordenRepCuerpo getOrden() {
        return orden;
    }

    public void setOrden(ordenRepCuerpo orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "DetalleRepuestos{" + "id=" + id + ", estado='" + estado + '\'' + ", repuesto=" + repuesto + ", orden="
                + orden + '}';
    }

}
