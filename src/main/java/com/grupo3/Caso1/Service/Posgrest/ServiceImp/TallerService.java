package com.grupo3.Caso1.Service.Posgrest.ServiceImp;

import com.grupo3.Caso1.Commons.MailAttachment;
import com.grupo3.Caso1.Commons.Utils;
import com.grupo3.Caso1.Dao.Posgrest.DetalleOrdenRepository;
import com.grupo3.Caso1.Dao.Posgrest.informeReclamoRepositori;
import com.grupo3.Caso1.Dao.Posgrest.ordenReparacion.ordenRepCuerpoRepo;
import com.grupo3.Caso1.Dao.Postgres.RepuestoRepository;
import com.grupo3.Caso1.Mappers.TallerMapper;
import com.grupo3.Caso1.Model.InformeReclamo;
import com.grupo3.Caso1.Model.LabelValue;
import com.grupo3.Caso1.Model.Repuestos;
import com.grupo3.Caso1.Model.ordenReparacion.DetalleRepuestos;
import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCuerpo;
import com.grupo3.Caso1.Reports.InformeReparacionContext;
import com.grupo3.Caso1.Reports.Report;
import com.grupo3.Caso1.Reports.ReporteGarantiaContex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TallerService {

    @Autowired
    private RepuestoRepository repuestoRepository;
    @Autowired
    private ordenRepCuerpoRepo ordenRepCuerpoRepo;
    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;
    @Autowired
    private informeReclamoRepositori informeReclamoRepository;

    public List<Map<String, Object>> getRepuestos() {
        return repuestoRepository.findAll().stream().map(TallerMapper::mappRepuesto).collect(Collectors.toList());
    }

    public Map<String, Object> addRepuestoToOrden(Long ordenId, Long repuestoId) {
        DetalleRepuestos detalle = new DetalleRepuestos();
        Repuestos repuesto = new Repuestos();
        repuesto.setId_repuesto(repuestoId);
        detalle.setRepuesto(repuesto);

        detalle.setOrden(ordenRepCuerpoRepo.findById(ordenId).get());
        detalle.setEstado("PENDIENTE");
        DetalleRepuestos detalleBD = detalleOrdenRepository.save(detalle);

        Map<String, Object> json = new HashMap<>();
        json.put("status", "created");
        json.put("id", detalleBD.getId());
        return json;
    }

    public List<Map<String, Object>> getRepuestosSolicitados(Long ordenId) {
        return detalleOrdenRepository.getDetalleRepuestosByIdOrden(ordenId).stream().map(TallerMapper::mappDetalleRepuestos).collect(Collectors.toList());
    }

    public Map<String, Object> deleteDetalleRepuesto(Long id) {
        Map<String, Object> json = new HashMap<>();
        try {
            detalleOrdenRepository.deleteById(id);
            json.put("status", "deleted");
        } catch (Exception e) {
            json.put("status", "error");
        }

        return json;

    }

    public String generarInformeReparacion(Long ordenId) {

        Optional<ordenRepCuerpo> ordenBD = ordenRepCuerpoRepo.findById(ordenId);
        if (ordenBD.isPresent()) {
            ordenRepCuerpo orden = ordenBD.get();
            Map<String, Object> objectMap = TallerMapper.mappOrden(orden);

            List<LabelValue> labelValues = (List<LabelValue>) objectMap.get("detallesVehiculo");

            String repuestos = orden.getDetalleRepuestos().stream().map((obj) -> obj.getRepuesto().getNombre_repuesto()).collect(Collectors.joining("\n"));

            String detallesLabels = labelValues.stream().map(LabelValue::getLabel).collect(Collectors.joining("\n"));
            String detallesValues = labelValues.stream().map(obj -> obj.getValue().toString()).collect(Collectors.joining("\n"));

            InformeReparacionContext context = new InformeReparacionContext();
            context.setOrden(String.valueOf(orden.getIdordenCuerpo()));
            context.setCliente(orden.getOrdenRepCavecera().getInspeCuerpo().getInspeCavecera().getInformeReclamo().getClient().getClienteLabel());
            context.setFecha(Utils.formatDate(orden.getOrdenRepCavecera().getFechaIngreso()));
            context.setEstado(orden.getEstadoOrden());
            context.setObservaciones(orden.getObservaciones());
            context.setNombresRepuestos(repuestos.trim());
            context.setDetallesLabels(detallesLabels.toUpperCase().trim());
            context.setDetallesValues(detallesValues.toUpperCase().trim());

            Double costoManoObra = orden.getOrdenRepCavecera().getCostoManoObra();
            if (costoManoObra != null) {
                context.setCostoManoObra(costoManoObra.toString());
            } else {
                context.setCostoManoObra("0.00");
            }

            Report<InformeReparacionContext> report = new Report<>("template", context);

            report.generate();
            return report.getReportOutPdfName();
        }
        return "";
    }


    public Map<String, Object> enviarEmail(Long ordenId) throws MessagingException {

        Map<String, Object> json = new HashMap<>();
        Optional<ordenRepCuerpo> ordenBD = ordenRepCuerpoRepo.findById(ordenId);

        if (ordenBD.isPresent()) {
            String pdfPath = this.generarInformeReparacion(ordenId);
            List<MailAttachment> attachments = List.of(new MailAttachment("INFORME REPARACIÓN.pdf", pdfPath));
            String email = ordenBD.get().getOrdenRepCavecera().getInspeCuerpo().getInspeCavecera().getInformeReclamo().getClient().getEmailClient();
            Boolean enviado = Utils.enviarEmail(email, "StarMotorsG3@gmail.com", "INFORME DE REPARACIÓN", "INFORME DE REPARACIÓN", attachments);

            if (enviado) {
                json.put("email", email);
                json.put("status", "enviado");
                return json;
            }
        }

        json.put("status", "error");

        return json;
    }


    public Map<String, Object> editarManoObra(Long ordenId, Double costo) {
        Map<String, Object> json = new HashMap<>();

        Optional<ordenRepCuerpo> orden = ordenRepCuerpoRepo.findById(ordenId);
        if (orden.isPresent()) {
            orden.get().getOrdenRepCavecera().setCostoManoObra(costo);
            ordenRepCuerpoRepo.save(orden.get());
            json.put("status", "editado");
        } else {
            json.put("status", "error");
        }

        return json;
    }

    public String generarInformeGarantia(Long id) {

        ReporteGarantiaContex context = new ReporteGarantiaContex();

        List<InformeReclamo> informes = informeReclamoRepository.findAll();


        /**
         * LOGICA DE ARMADO DEL REPORTE DE GARANTIA
         */

        String estados = informes.stream().map(InformeReclamo::getTipoInforme).collect(Collectors.joining("\n"));
        context.setEstados(estados);

        String marcas = informes.stream().map(obj -> obj.getReclamogarantia().getFk_id_solicitud().getFk_chasis_vehiculo().getVehiculoCatalogo().getDiseno().getMarca()).collect(Collectors.joining("\n"));
        context.setMarcas(marcas);

        String modelos = informes.stream().map(obj -> obj.getReclamogarantia().getFk_id_solicitud().getFk_chasis_vehiculo().getVehiculoCatalogo().getDiseno().getModelo()).collect(Collectors.joining("\n"));
        context.setModelos(modelos);

        String paises = informes.stream().map(obj -> obj.getReclamogarantia().getFk_id_solicitud().getFk_chasis_vehiculo().getPais().getNombre()).collect(Collectors.joining("\n"));
        context.setPaises(paises);

        String colors = informes.stream().map(obj -> obj.getReclamogarantia().getFk_id_solicitud().getFk_chasis_vehiculo().getColor()).collect(Collectors.joining("\n"));
        context.setColores(colors);

        String anios = informes.stream().map(obj -> obj.getReclamogarantia().getFk_id_solicitud().getFk_chasis_vehiculo().getVehiculoCatalogo().getYear_vehiculo() + "").collect(Collectors.joining("\n"));
        context.setAnios(anios);

        Report<ReporteGarantiaContex> report = new Report<>("reporte_garantia", context);
        report.generate();

        return report.getReportOutPdfName();
    }

    public List<Map<String, Object>> getOrdenesTaller(String estado) {
        List<ordenRepCuerpo> ordenesRep = ordenRepCuerpoRepo.getOrdenesTaller(estado);
        return ordenesRep.stream().map(TallerMapper::mappOrden).collect(Collectors.toList());
    }
}
