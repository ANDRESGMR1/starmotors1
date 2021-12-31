package com.grupo3.Caso1.Service.Posgrest.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.PaisRepositorio;
import com.grupo3.Caso1.Model.Pais;
import com.grupo3.Caso1.Service.Posgrest.PaisService;

@Service
public class PaisServiceImp extends GenericServiceImp<Pais, Long> implements PaisService{
	
	@Autowired
	private PaisRepositorio pais;

	@Override
	public CrudRepository<Pais, Long> getDao() {
		// TODO Auto-generated method stub
		return pais;
	}

}
