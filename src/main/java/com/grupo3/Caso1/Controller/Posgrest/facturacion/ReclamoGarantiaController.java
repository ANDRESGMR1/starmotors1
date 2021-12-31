package com.grupo3.Caso1.Controller.Posgrest.facturacion;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.Caso1.Model.ReclamoGarantia;
import com.grupo3.Caso1.Service.Posgrest.ReclamoGarantiaService;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.facturacion.ReclamoGarantiaSercImpl;

@RestController
@RequestMapping("/reclamo/garantia/api/v1/")
@CrossOrigin("*")
public class ReclamoGarantiaController {

	@Autowired
	private ReclamoGarantiaService garantiaService;
	@Autowired
	private ReclamoGarantiaSercImpl garantiaSercImpl;

	@GetMapping
	private ResponseEntity<List<ReclamoGarantia>> getAllReclamoGarantia() {
		return ResponseEntity.ok(garantiaService.getAll());
	}

	@PostMapping
	private ResponseEntity<ReclamoGarantia> saveReclamoGarantia(@RequestBody ReclamoGarantia solicitud) {
		try {
			ReclamoGarantia reclamoGar = garantiaService.save(solicitud);
			return ResponseEntity.created(new URI("/reclamo/garantia/api/v1/" + reclamoGar.getId_reclamo()))
					.body(reclamoGar);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/findId/{id}")
	public ReclamoGarantia getfindbyid(@PathVariable(name = "id") Long id) {
		ReclamoGarantia reclamoGarantia = garantiaService.get(id);
		return reclamoGarantia;
	}

	@PutMapping("{id}")
	public ResponseEntity<?> cambiarEstadoReclamo(@PathVariable("id") Long id) {
		garantiaSercImpl.cambiarEstadoReclamo(id);
		return ResponseEntity.ok(garantiaService.getAll());
	}
}
