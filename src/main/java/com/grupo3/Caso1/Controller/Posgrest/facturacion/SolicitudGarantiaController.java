package com.grupo3.Caso1.Controller.Posgrest.facturacion;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.Caso1.Model.Client;
import com.grupo3.Caso1.Model.Factura;
import com.grupo3.Caso1.Model.MisVehiculos;
import com.grupo3.Caso1.Model.SolicitudGarantia;
import com.grupo3.Caso1.Model.Vehiculo;
import com.grupo3.Caso1.Service.Posgrest.SolicitudGarantiaService;
import com.grupo3.Caso1.Service.Posgrest.VehiculoService;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.facturacion.SolicitudGarantiaServImpl;

@RestController
@RequestMapping("/solicitud/garantia/api/v1/")
@CrossOrigin("*")
public class SolicitudGarantiaController {

	@Autowired
	private SolicitudGarantiaService garantiaService;
	@Autowired
	private SolicitudGarantiaServImpl garantiaServImpl;
	@Autowired
	private VehiculoService vehiculoService;

	@GetMapping
	private ResponseEntity<List<SolicitudGarantia>> getAllSoliGarantia() {
		return ResponseEntity.ok(garantiaService.getAll());
	}

	@GetMapping("/find/{id}")
	private SolicitudGarantia getSolGarantiaByID(@PathVariable("id") Long idSoliGarantia) {
		return garantiaService.get(idSoliGarantia);
	}

	@PostMapping
	private ResponseEntity<SolicitudGarantia> saveSoliGarantia(@RequestBody SolicitudGarantia solicitud) {
		try {
			SolicitudGarantia solicitudGar = garantiaService.save(solicitud);
			return ResponseEntity.created(new URI("/solicitud/garantia/api/v1/" + solicitudGar.getId_solicitud()))
					.body(solicitudGar);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "{id}")
	private ResponseEntity<Boolean> deleteSoliGarantia(@PathVariable("id") Long idSoliGarantia) {
		garantiaService.delete(idSoliGarantia);
		return ResponseEntity.ok(!(garantiaService.get(idSoliGarantia) != null));
	}

	@GetMapping("{estado}")
	private ResponseEntity<List<SolicitudGarantia>> getAllSoliGarTrue(@PathVariable("estado") Boolean estado) {
		return ResponseEntity.ok(garantiaServImpl.findAllByEstado(estado));
	}

	@PutMapping("{id}")
	public ResponseEntity<?> cambiarEstadoReclamo(@PathVariable("id") Long id) {
		garantiaServImpl.cambiarEstadoSolicitud(id);
		return ResponseEntity.ok(garantiaService.getAll());
	}

	@GetMapping("cars/{id}")
	public ResponseEntity<List<String>> getCarsByCedula(@PathVariable("id") String id) {
		return ResponseEntity.ok(garantiaServImpl.listCarsByCedula(id));
	}

	@PostMapping("save/{id}")
	public ResponseEntity<SolicitudGarantia> postSolicitudId(@PathVariable("id") String id, @RequestBody SolicitudGarantia soli) {
		Vehiculo vehiculo = vehiculoService.get(id);
		soli.setFk_chasis_vehiculo(vehiculo);
		soli.setEstado_solicitud(true);
		SolicitudGarantia obj = garantiaService.save(soli);
		return new ResponseEntity<SolicitudGarantia>(obj, HttpStatus.OK);
	}

	@GetMapping("facturas/{inicio}/{fin}")
	public ResponseEntity<List<Factura>> getFact(@PathVariable("inicio") Date inicio, @PathVariable("fin") Date fin) {
		return ResponseEntity.ok(garantiaServImpl.findByDate(inicio,fin));
	}
	
}
