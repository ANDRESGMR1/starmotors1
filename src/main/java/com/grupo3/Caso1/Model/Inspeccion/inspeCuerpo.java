package com.grupo3.Caso1.Model.Inspeccion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class inspeCuerpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idinspeCuerpo;
    @ManyToOne
    @JoinColumn(name = "idinspeccionCavecera")
    private inspeCavecera inspeCavecera;
    private String luces;
    private String parabrisas;
    private String bateria;
    private String liquido_transmicion;
    private String direccion;
    private String refrigerante;
    private String filtro_cabina;
    private String filtro_aire;
    private String cinturones;
    private String frenos;
    private String suspencion;
    private String eje;
    private String escape;
    private String patron_desgaste_neomatico;
    private String tipo_reparacion_neomatico;
    private String observaciones;

    public inspeCuerpo() {
    }

    public inspeCuerpo(Long idinspeCuerpo, com.grupo3.Caso1.Model.Inspeccion.inspeCavecera inspeCavecera, String luces,
            String parabrisas, String bateria, String liquido_transmicion, String direccion, String refrigerante,
            String filtro_cabina, String filtro_aire, String cinturones, String frenos, String suspencion, String eje,
            String escape, String patron_desgaste_neomatico, String tipo_reparacion_neomatico, String observaciones) {
        this.idinspeCuerpo = idinspeCuerpo;
        this.inspeCavecera = inspeCavecera;
        this.luces = luces;
        this.parabrisas = parabrisas;
        this.bateria = bateria;
        this.liquido_transmicion = liquido_transmicion;
        this.direccion = direccion;
        this.refrigerante = refrigerante;
        this.filtro_cabina = filtro_cabina;
        this.filtro_aire = filtro_aire;
        this.cinturones = cinturones;
        this.frenos = frenos;
        this.suspencion = suspencion;
        this.eje = eje;
        this.escape = escape;
        this.patron_desgaste_neomatico = patron_desgaste_neomatico;
        this.tipo_reparacion_neomatico = tipo_reparacion_neomatico;
        this.observaciones = observaciones;
    }

    public Long getIdinspeCuerpo() {
        return idinspeCuerpo;
    }

    public void setIdinspeCuerpo(Long idinspeCuerpo) {
        this.idinspeCuerpo = idinspeCuerpo;
    }

    public inspeCavecera getInspeCavecera() {
        return inspeCavecera;
    }

    public void setInspeCavecera(inspeCavecera inspeCavecera) {
        this.inspeCavecera = inspeCavecera;
    }

    public String getLuces() {
        return luces;
    }

    public void setLuces(String luces) {
        this.luces = luces;
    }

    public String getParabrisas() {
        return parabrisas;
    }

    public void setParabrisas(String parabrisas) {
        this.parabrisas = parabrisas;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public String getLiquido_transmicion() {
        return liquido_transmicion;
    }

    public void setLiquido_transmicion(String liquido_transmicion) {
        this.liquido_transmicion = liquido_transmicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(String refrigerante) {
        this.refrigerante = refrigerante;
    }

    public String getFiltro_cabina() {
        return filtro_cabina;
    }

    public void setFiltro_cabina(String filtro_cabina) {
        this.filtro_cabina = filtro_cabina;
    }

    public String getFiltro_aire() {
        return filtro_aire;
    }

    public void setFiltro_aire(String filtro_aire) {
        this.filtro_aire = filtro_aire;
    }

    public String getCinturones() {
        return cinturones;
    }

    public void setCinturones(String cinturones) {
        this.cinturones = cinturones;
    }

    public String getFrenos() {
        return frenos;
    }

    public void setFrenos(String frenos) {
        this.frenos = frenos;
    }

    public String getSuspencion() {
        return suspencion;
    }

    public void setSuspencion(String suspencion) {
        this.suspencion = suspencion;
    }

    public String getEje() {
        return eje;
    }

    public void setEje(String eje) {
        this.eje = eje;
    }

    public String getEscape() {
        return escape;
    }

    public void setEscape(String escape) {
        this.escape = escape;
    }

    public String getPatron_desgaste_neomatico() {
        return patron_desgaste_neomatico;
    }

    public void setPatron_desgaste_neomatico(String patron_desgaste_neomatico) {
        this.patron_desgaste_neomatico = patron_desgaste_neomatico;
    }

    public String getTipo_reparacion_neomatico() {
        return tipo_reparacion_neomatico;
    }

    public void setTipo_reparacion_neomatico(String tipo_reparacion_neomatico) {
        this.tipo_reparacion_neomatico = tipo_reparacion_neomatico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
