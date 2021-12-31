package com.grupo3.Caso1.Controller.Postgres;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import java.util.HashMap;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.Caso1.Model.DetalleFactura;
import com.grupo3.Caso1.Model.Factura;
import com.grupo3.Caso1.Model.Vehiculo;
import com.grupo3.Caso1.Service.Posgrest.VehiculoService;
import com.grupo3.Caso1.Service.Postgres.FacturaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/facturas/api/v1")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private VehiculoService vehiculoService;

	@GetMapping("/")
	public List<Factura> getFacturas() {
		return facturaService.findAll();
	}
	//ENDPOINT QUE REGRESA LAS FACTURAS DEL CLIENTE CON PARAMETRO LA CEDULA 
	@GetMapping("/facturas-cliente/{cedula}")
	public List<Factura> getFacturasByCedulaCliente(@PathVariable String cedula) {
		return facturaService.findFacturaByClienteCedulaClient(cedula);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Factura factura = null;
		Map<String, Object> response = new HashMap<>();
		try {
			factura = facturaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la consulta de la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (factura == null) {
			response.put("mensaje", "La factura ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Factura>(factura, HttpStatus.OK);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Factura factura, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Factura newFactura = null;
		Vehiculo veh=null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			for (DetalleFactura detalleFactura:factura.getDetallesfacturas()) {
				veh= vehiculoService.get(detalleFactura.getVehiculo().getChasis());
				veh.setEstado(false);
				vehiculoService.save(veh);
			}
			newFactura = facturaService.save(factura);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error  en la inserccion en la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Factura guardada con exito");
		response.put("factura", newFactura);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Factura factura, BindingResult result, @PathVariable Long id) {
		Factura fac = facturaService.findById(id);

		Factura facupd = null;

		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (fac == null) {
			response.put("mensaje", "Error:no se pudo editar, la factura ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			fac.setDescripcion(factura.getDescripcion());
			fac.setDireccion(factura.getDireccion());
			fac.setRuc_factura(factura.getRuc_factura());
			fac.setNombre_empresa(factura.getNombre_empresa());
			fac.setFecha_emision(factura.getFecha_emision());
			fac.setCliente(factura.getCliente());
			fac.setDetallesfacturas(factura.getDetallesfacturas());
			facupd = facturaService.save(fac);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el factura en la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Factura actualizada con exito");
		response.put("factura", facupd);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Vehiculo veh=null;
		Factura fac=null;
		try {
			fac=facturaService.findById(id);
			for (DetalleFactura detalleFactura:fac.getDetallesfacturas()) {
				veh= vehiculoService.get(detalleFactura.getVehiculo().getChasis());
				veh.setEstado(true);
				vehiculoService.save(veh);
			}
			facturaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el factura en la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Factura eliminada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
