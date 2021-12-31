package com.grupo3.Caso1.Mappers;

import com.grupo3.Caso1.Commons.Utils;
import com.grupo3.Caso1.Model.Inspeccion.inspeCuerpo;
import com.grupo3.Caso1.Model.LabelValue;
import com.grupo3.Caso1.Model.Repuestos;
import com.grupo3.Caso1.Model.ordenReparacion.DetalleRepuestos;
import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCuerpo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TallerMapper {

    public static Map<String, Object> mappOrden(ordenRepCuerpo obj) {

        Map<String, Object> json = new HashMap<>();
        json.put("id", obj.getIdordenCuerpo());
        json.put("persona", obj.getOrdenRepCavecera().getInspeCuerpo().getInspeCavecera().getInformeReclamo().getClient().getClienteObject());
        json.put("fechaIngreso", Utils.formatDate(obj.getOrdenRepCavecera().getFechaIngreso()));
        json.put("estado", obj.getEstadoOrden());

        List<LabelValue> detallesVehiculo = new ArrayList<>();

        inspeCuerpo cuerpoInspeccion = obj.getOrdenRepCavecera().getInspeCuerpo();

        detallesVehiculo.add(new LabelValue("Bateria", cuerpoInspeccion.getBateria()));
        detallesVehiculo.add(new LabelValue("Cintirunes", cuerpoInspeccion.getCinturones()));
        detallesVehiculo.add(new LabelValue("Dirección", cuerpoInspeccion.getDireccion()));
        detallesVehiculo.add(new LabelValue("Eje", cuerpoInspeccion.getEje()));
        detallesVehiculo.add(new LabelValue("Escape", cuerpoInspeccion.getEscape()));
        detallesVehiculo.add(new LabelValue("Filtro de Aire", cuerpoInspeccion.getFiltro_aire()));
        detallesVehiculo.add(new LabelValue("Filtro de cabina", cuerpoInspeccion.getFiltro_cabina()));
        detallesVehiculo.add(new LabelValue("Frenos", cuerpoInspeccion.getFrenos()));
        detallesVehiculo.add(new LabelValue("Liquido de transmicion", cuerpoInspeccion.getLiquido_transmicion()));
        detallesVehiculo.add(new LabelValue("Luces", cuerpoInspeccion.getLuces()));
        detallesVehiculo.add(new LabelValue("Parabrisas", cuerpoInspeccion.getParabrisas()));
        detallesVehiculo.add(new LabelValue("Patron de desgaste neumatico", cuerpoInspeccion.getPatron_desgaste_neomatico()));
        detallesVehiculo.add(new LabelValue("Refrigerante", cuerpoInspeccion.getRefrigerante()));
        detallesVehiculo.add(new LabelValue("Suspención", cuerpoInspeccion.getSuspencion()));
        detallesVehiculo.add(new LabelValue("Tipo de reparación neumatico", cuerpoInspeccion.getTipo_reparacion_neomatico()));


        json.put("detallesVehiculo", detallesVehiculo);
        json.put("costoManoObra", obj.getOrdenRepCavecera().getCostoManoObra());
        json.put("observaciones", obj.getOrdenRepCavecera().getInspeCuerpo().getObservaciones());
        return json;
    }

    public static Map<String, Object> mappRepuesto(Repuestos repuesto) {
        Map<String, Object> json = new HashMap<>();
        json.put("label", repuesto.getNombre_repuesto());
        json.put("value", repuesto.getId_repuesto());
        return json;
    }

    public static Map<String, Object> mappDetalleRepuestos(DetalleRepuestos detalle) {
        Map<String, Object> json = new HashMap<>();

        json.put("id", detalle.getId());
        json.put("estado", detalle.getEstado());
        json.put("orden_id", detalle.getOrden().getIdordenCuerpo());


        Map<String, Object> jsonRepuesto = new HashMap<>();

        jsonRepuesto.put("id", detalle.getRepuesto().getId_repuesto());
        jsonRepuesto.put("nombre", detalle.getRepuesto().getNombre_repuesto());

        json.put("repuesto", jsonRepuesto);

        return json;
    }

}
