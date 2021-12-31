package com.grupo3.Caso1.Model.ordenReparacion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import com.grupo3.Caso1.Commons.Utils;
import com.grupo3.Caso1.Model.Inspeccion.inspeCuerpo;

@Entity
public class ordenRepCavecera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idordenCave;
    public Date fecha_emision;
    public Date fechaIngreso;
    @ManyToOne
    @JoinColumn(name = "idinspeCuerpo")
    private inspeCuerpo inspeCuerpo;
    private Double costoManoObra;

    public ordenRepCavecera() {
    }

    public ordenRepCavecera(Long idordenCave, Date fecha_emision, Date fechaIngreso, com.grupo3.Caso1.Model.Inspeccion.inspeCuerpo inspeCuerpo) {
        this.idordenCave = idordenCave;
        this.fecha_emision = fecha_emision;
        this.fechaIngreso = fechaIngreso;
        this.inspeCuerpo = inspeCuerpo;
    }

    public Long getIdordenCave() {
        return idordenCave;
    }

    public void setIdordenCave(Long idordenCave) {
        this.idordenCave = idordenCave;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public inspeCuerpo getInspeCuerpo() {
        return inspeCuerpo;
    }

    public void setInspeCuerpo(inspeCuerpo inspeCuerpo) {
        this.inspeCuerpo = inspeCuerpo;
    }

   /* public String getFechaIngresoWithFormat() {
        return Utils.formatDate(this.fechaIngreso);
    }*/

    public Double getCostoManoObra() {
        return costoManoObra;
    }

    public void setCostoManoObra(Double costoManoObra) {
        this.costoManoObra = costoManoObra;
    }
}
