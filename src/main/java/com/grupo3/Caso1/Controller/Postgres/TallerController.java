package com.grupo3.Caso1.Controller.Postgres;

import com.grupo3.Caso1.Commons.Utils;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/taller/api/v1/")
@CrossOrigin("*")
public class TallerController {

    @Autowired
    private TallerService tallerService;

    @GetMapping("respuestos")
    private List<Map<String, Object>> getRepuestos() {
        return tallerService.getRepuestos();
    }

    @PostMapping("add-repuesto/{ordenId}/{repuestoId}")
    private Map<String, Object> addRepuestoToOrden(@PathVariable("ordenId") Long ordenId, @PathVariable("repuestoId") Long repuestoId) {
        return tallerService.addRepuestoToOrden(ordenId, repuestoId);
    }

    @GetMapping("repuesto-solicitados/{ordenId}")
    private List<Map<String, Object>> getRepuestosSolicitados(@PathVariable("ordenId") Long ordenId) {
        return tallerService.getRepuestosSolicitados(ordenId);
    }

    @DeleteMapping("delete-detalle-repuesto/{id}")
    private Map<String, Object> deleteDetalleRepuesto(@PathVariable("id") Long id) {
        return tallerService.deleteDetalleRepuesto(id);
    }

//    @GetMapping("informe-reparacion/{ordenId}")
//    private Map<String, Object> generarInformeReparacion(@PathVariable("ordenId") Long ordenId) {
//        return tallerService.generarInformeReparacion(ordenId);
//    }


    @GetMapping("informe-reparacion-pdf/{ordenId}")
    public ResponseEntity<byte[]> generarInformeReparacionPDF(@PathVariable("ordenId") Long ordenId) throws IOException {
        String pdfName = tallerService.generarInformeReparacion(ordenId);
        return Utils.responsePdf(pdfName);
    }

    @GetMapping("enviar-correo-informe-reparacion/{ordenId}")
    public Map<String, Object> enviarCorreoInformeReparacion(@PathVariable("ordenId") Long ordenId) throws MessagingException {
        return this.tallerService.enviarEmail(ordenId);
    }

    @PutMapping("editar-costo-mano-obra/{ordenId}")
    private Map<String, Object> editarManoObra(@PathVariable("ordenId") Long ordenId, @RequestBody Double costo) {
        return tallerService.editarManoObra(ordenId, costo);
    }

    @GetMapping("informe-garantia-pdf/{id}")
    public ResponseEntity<byte[]> generarInformeGarantiaPdf(@PathVariable("id") Long id) throws IOException {

        String pdfPath = tallerService.generarInformeGarantia(id);
        return Utils.responsePdf(pdfPath);
    }

    @GetMapping("/ordenes-taller/{estado}")
    public List<Map<String, Object>> getOrdenesTaller(@PathVariable(name = "estado") String estado) {
        return tallerService.getOrdenesTaller(estado);
    }
}
