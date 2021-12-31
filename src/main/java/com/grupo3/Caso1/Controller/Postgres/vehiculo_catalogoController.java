package com.grupo3.Caso1.Controller.Postgres;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.Caso1.Model.vehiculo_catalogo;
import com.grupo3.Caso1.Service.Postgres.vehiculo_catalogoService;

@RestController
@RequestMapping("/vehiculo_catalogo/api/v1")
@CrossOrigin("*")
public class vehiculo_catalogoController {
	
	@Autowired
	private vehiculo_catalogoService vehiculoservice;
	
	
	@GetMapping(value="/all")
	public List<vehiculo_catalogo> getAll(){
		return vehiculoservice.getAll();
	}

	@GetMapping(value="/find/{id_vehiculo_catalogo}")
	public vehiculo_catalogo find(@PathVariable Long id_vehiculo_catalogo) {
		return vehiculoservice.get(id_vehiculo_catalogo);
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<vehiculo_catalogo> save(@RequestBody vehiculo_catalogo vehiculocatalogo){
		vehiculo_catalogo obj= vehiculoservice.save(vehiculocatalogo);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id_vehiculo_catalogo}")
	public ResponseEntity<Boolean> delete(@PathVariable("id_vehiculo_catalogo") Long id_vehiculo_catalogo){
		vehiculoservice.delete(id_vehiculo_catalogo);
		return ResponseEntity.ok(!(vehiculoservice.get(id_vehiculo_catalogo)!=null));
	}


}