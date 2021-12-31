package com.grupo3.Caso1.Controller.Posgrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grupo3.Caso1.Model.DetalleGarantia;
import com.grupo3.Caso1.Service.Posgrest.DetalleGarantiaService;

@RestController
@RequestMapping("/detalleg/api/v1")
@CrossOrigin("*")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class DetalleGarantiaController {
	
	@Autowired
	private DetalleGarantiaService detalleService;

	@GetMapping(value = "/all")
	public List<DetalleGarantia> getAll() {
		return detalleService.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public DetalleGarantia find(@PathVariable(value = "id") Long id) {
		return detalleService.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<DetalleGarantia> save(@RequestBody DetalleGarantia vehiculo) {
		DetalleGarantia obj = detalleService.save(vehiculo);
		return new ResponseEntity<DetalleGarantia>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<DetalleGarantia> delete(@PathVariable(value = "id") Long id) {
		DetalleGarantia vehiculo = detalleService.get(id);
		if (vehiculo != null) {
			detalleService.delete(id);
		} else {
			return new ResponseEntity<DetalleGarantia>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DetalleGarantia>(vehiculo, HttpStatus.OK);
	}

}
