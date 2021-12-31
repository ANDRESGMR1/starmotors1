package com.grupo3.Caso1.Service.Postgres.ServiceImpPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Postgres.vehiculo_catalogoRepository;
import com.grupo3.Caso1.Model.vehiculo_catalogo;
import com.grupo3.Caso1.Service.Postgres.vehiculo_catalogoService;

@Service
public class vehiculo_catalogoServiceImp extends GenericServiceImp<vehiculo_catalogo, Long> implements vehiculo_catalogoService{

	@Autowired
	private vehiculo_catalogoRepository vehiculocatal;
	
	@Override
	public CrudRepository<vehiculo_catalogo, Long> getDao() {
		// TODO Auto-generated method stub
		return vehiculocatal;
	}

	
}
