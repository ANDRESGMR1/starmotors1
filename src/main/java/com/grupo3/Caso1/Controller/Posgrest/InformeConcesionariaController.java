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

import com.grupo3.Caso1.Model.ConcecionariaInforme;
import com.grupo3.Caso1.Model.InformeConcecionaria;
import com.grupo3.Caso1.Service.Posgrest.InformeConcesionariaService;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.InformeConcesionariaServiceImp;

@RestController
@RequestMapping("/informeC/api/v1")
@CrossOrigin("*")
public class InformeConcesionariaController {
	@Autowired
	private InformeConcesionariaService informeService;
	@Autowired
	private InformeConcesionariaServiceImp informeImp;
	
	@GetMapping(value = "/all")
	public List<InformeConcecionaria> getAll() {
		return informeService.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public InformeConcecionaria find(@PathVariable(value = "id") Long id) {
		return informeService.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<InformeConcecionaria> save(@RequestBody InformeConcecionaria informe) {
		
		InformeConcecionaria obj = informeService.save(informe);
		return new ResponseEntity<InformeConcecionaria>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
		informeService.delete(id);
		return ResponseEntity.ok(!(informeService.get(id)!=null));
	}

	@GetMapping("/cars/{id}")
	public ResponseEntity<List<ConcecionariaInforme>> getCarsByCedula(@PathVariable("id") Long id) {
		return ResponseEntity.ok(informeImp.MostarDatosTodo(id));
	}

	}
