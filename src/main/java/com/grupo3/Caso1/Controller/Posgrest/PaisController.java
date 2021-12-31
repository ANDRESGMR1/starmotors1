package com.grupo3.Caso1.Controller.Posgrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.Caso1.Model.Pais;
import com.grupo3.Caso1.Service.Posgrest.PaisService;

@RestController
@RequestMapping("/pais/api/v1")
@CrossOrigin("*")
public class PaisController {
	
	@Autowired
	private PaisService pais;

	@GetMapping(value = "/all")
	public List<Pais> getAll() {
		return pais.getAll();
	}


}
