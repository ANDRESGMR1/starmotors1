package com.grupo3.Caso1.Model.ordenReparacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ordenRepCuerpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idordenCuerpo;
    @ManyToOne
    @JoinColumn(name = "idordenCave")
    private ordenRepCavecera ordenRepCavecera;
    private String trabajoSolicitado;
    private String trabajoRealizar;
    private String observaciones;
    private String imagenes;
    private String estadoOrden;

    @OneToMany(mappedBy = "orden")
    private List<DetalleRepuestos> detalleRepuestos = new ArrayList<>();

    public ordenRepCuerpo() {
    }

    public ordenRepCuerpo(Long idordenCuerpo, com.grupo3.Caso1.Model.ordenReparacion.ordenRepCavecera ordenRepCavecera,
            String trabajoSolicitado, String trabajoRealizar, String observaciones, String imagenes,
            String estadoOrden) {
        this.idordenCuerpo = idordenCuerpo;
        this.ordenRepCavecera = ordenRepCavecera;
        this.trabajoSolicitado = trabajoSolicitado;
        this.trabajoRealizar = trabajoRealizar;
        this.observaciones = observaciones;
        this.imagenes = imagenes;
        this.estadoOrden = estadoOrden;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public Long getIdordenCuerpo() {
        return idordenCuerpo;
    }

    public void setIdordenCuerpo(Long idordenCuerpo) {
        this.idordenCuerpo = idordenCuerpo;
    }

    public ordenRepCavecera getOrdenRepCavecera() {
        return ordenRepCavecera;
    }

    public void setOrdenRepCavecera(ordenRepCavecera ordenRepCavecera) {
        this.ordenRepCavecera = ordenRepCavecera;
    }

    public String getTrabajoSolicitado() {
        return trabajoSolicitado;
    }

    public void setTrabajoSolicitado(String trabajoSolicitado) {
        this.trabajoSolicitado = trabajoSolicitado;
    }

    public String getTrabajoRealizar() {
        return trabajoRealizar;
    }

    public void setTrabajoRealizar(String trabajoRealizar) {
        this.trabajoRealizar = trabajoRealizar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public List<DetalleRepuestos> getDetalleRepuestos() {
        return detalleRepuestos;
    }

    public void setDetalleRepuestos(List<DetalleRepuestos> detalleRepuestos) {
        this.detalleRepuestos = detalleRepuestos;
    }

}
