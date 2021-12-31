package com.grupo3.Caso1.Reports;




public class InformeReparacionContext {
    private String orden;
    private String cliente;
    private String fecha;
    private String estado;
    private String observaciones;
    private String detallesLabels;
    private String detallesValues;
    private String nombresRepuestos;
    private String costoManoObra;

    
    public String getOrden() {
        return orden;
    }
    public void setOrden(String orden) {
        this.orden = orden;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getDetallesLabels() {
        return detallesLabels;
    }
    public void setDetallesLabels(String detallesLabels) {
        this.detallesLabels = detallesLabels;
    }
    public String getDetallesValues() {
        return detallesValues;
    }
    public void setDetallesValues(String detallesValues) {
        this.detallesValues = detallesValues;
    }
    public String getNombresRepuestos() {
        return nombresRepuestos;
    }
    public void setNombresRepuestos(String nombresRepuestos) {
        this.nombresRepuestos = nombresRepuestos;
    }
    public String getCostoManoObra() {
        return costoManoObra;
    }
    public void setCostoManoObra(String costoManoObra) {
        this.costoManoObra = costoManoObra;
    }
}


