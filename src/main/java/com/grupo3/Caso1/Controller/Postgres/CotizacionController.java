package com.grupo3.Caso1.Controller.Postgres;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.Caso1.Model.Cotizacion;
import com.grupo3.Caso1.Service.Postgres.CotizacionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cotizaciones/api/v1")
public class CotizacionController {

	@Autowired
	private CotizacionService cotizacionService;

	// ENVIA AL EMAIL LA COTIZACION NOTA --> TIENE QUE PRIMERO GUARDAR LA COTIZACION
	// Y ENVIAR AL EMAIL POR ID DE LA COTIZACION
	@GetMapping("enviar-correo-cotizacion")
	public String enviarCorreoCotizacion(@RequestParam("chasis") Long id,
			@RequestParam("nombreClient") String nombre, @RequestParam("emailClient") String email)
			throws MessagingException {
		return this.cotizacionService.enviarEmail(id, nombre, email);
	}

	@GetMapping("/")
	public List<Cotizacion> getCotizacions() {
		return cotizacionService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Cotizacion cotizacion = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cotizacion = cotizacionService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la consulta de la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cotizacion == null) {
			response.put("mensaje",
					"La Cotizacion ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cotizacion>(cotizacion, HttpStatus.OK);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Cotizacion cotizacion, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Cotizacion newCotizacion = null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			newCotizacion = cotizacionService.save(cotizacion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error  en la inserccion en la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cotizacion guardada con exito");
		response.put("cotizacion", newCotizacion);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cotizacion cotizacion, BindingResult result,
			@PathVariable Long id) {
		Cotizacion cot = cotizacionService.findById(id);

		Cotizacion cotupd = null;

		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (cot == null) {
			response.put("mensaje", "Error:no se pudo editar, la Cotizacion ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {

			cot.setCliente(cotizacion.getCliente());
			cot.setVehiculo_catalogo(cotizacion.getVehiculo_catalogo());
			cot.setTotal(cotizacion.getTotal());
			cotupd = cotizacionService.save(cot);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la Cotizacion en la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cotizacion actualizada con exito");
		response.put("cotizacion", cotupd);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			cotizacionService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la Cotizacion en la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cotizacion eliminada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
