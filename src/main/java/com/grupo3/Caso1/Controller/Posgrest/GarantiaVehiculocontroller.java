package com.grupo3.Caso1.Controller.Posgrest;

import java.util.List;

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

import com.grupo3.Caso1.Model.GarantiaVehiculo;
import com.grupo3.Caso1.Model.Vehiculo;
import com.grupo3.Caso1.Service.Posgrest.GarantiaVehiculoService;
import com.grupo3.Caso1.Service.Posgrest.VehiculoService;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.GarantiaVehiculoServiceImp;

@RestController
@RequestMapping("/garantia/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class GarantiaVehiculocontroller {
	@Autowired
	private GarantiaVehiculoService vehiculoService;
	@Autowired
	private GarantiaVehiculoServiceImp vehiculoImp;

	@GetMapping(value = "/all")
	public List<GarantiaVehiculo> getAll() {
		return vehiculoService.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public GarantiaVehiculo find(@PathVariable(value = "id") Long id) {
		return vehiculoService.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<GarantiaVehiculo> save(@RequestBody GarantiaVehiculo vehiculo) {
		
		GarantiaVehiculo obj = vehiculoService.save(vehiculo);
		
		return new ResponseEntity<GarantiaVehiculo>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
		vehiculoService.delete(id);
		return ResponseEntity.ok(!(vehiculoService.get(id)!=null));
	}
	@PutMapping("{id}")
	public ResponseEntity<?> cambiarEstadoReclamo(@PathVariable("id") Long id) {
		vehiculoImp.cambiarEstadoSolicitud(id);
		return ResponseEntity.ok(vehiculoService.getAll());
	}

}
