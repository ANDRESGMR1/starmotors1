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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.Caso1.Model.Vehiculo;
import com.grupo3.Caso1.Service.Posgrest.VehiculoService;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.VehiculoServiceImp;

@RestController
@RequestMapping("/vehiculo/api/v1")
@CrossOrigin("*")
public class VehiculoController {
	@Autowired
	private VehiculoService vehiculoService;
	
	@Autowired 
	private VehiculoServiceImp vehiculoimp;
	@GetMapping(value = "/all")
	public List<Vehiculo> getAll() {
		return vehiculoService.getAll();
	}
	//LISTAR VEHICULOS EN ESTADO FALSO PARA LA FACTURA
	@GetMapping(value = "/all-true")
	public List<Vehiculo> findAllEstadoFalse() {
		return vehiculoService.findAllEstadoFalse();
	}
	//LISTAR VEHICULOS POR PARAMETRO DE BUSQUEDA DE MARCA O MODELO Y EN ESTADO FALSO PARA LA FACTURA
	@GetMapping(value = "/all-filtrar/{marcaOrModelo}")
	public List<Vehiculo> findAllByMarcaOrModeloAndEstado(@PathVariable String marcaOrModelo) {
		return vehiculoService.findAllByMarcaOrModeloAndEstado(marcaOrModelo);
	}
	//ENDPOINT NECESARIO PARA LA FACTURA NO BORRAR
	@GetMapping(value = "/vc/{id}")
	public Vehiculo findVehiculoByVehiculoCatalogoId(@PathVariable Integer id) {
		return vehiculoService.findVehiculoByIdVehiculoCatalogo(id);
	}

	@GetMapping(value = "/find/{id}")
	public Vehiculo find(@PathVariable(value = "id") String id) {
		return vehiculoService.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Vehiculo> save(@RequestBody Vehiculo vehiculo) {
		
		Vehiculo obj = vehiculoService.save(vehiculo);
		return new ResponseEntity<Vehiculo>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
		vehiculoService.delete(id);
		return ResponseEntity.ok(!(vehiculoService.get(id)!=null));
	}
	@GetMapping("est/{estado}")
	private ResponseEntity<List<Vehiculo>> getAllSoliGarTrue(@PathVariable("estado") Boolean estado){
		return ResponseEntity.ok(vehiculoimp.findAllByEstado(estado));
	}

}
