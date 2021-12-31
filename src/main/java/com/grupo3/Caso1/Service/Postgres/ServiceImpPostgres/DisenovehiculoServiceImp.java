package com.grupo3.Caso1.Service.Postgres.ServiceImpPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Postgres.DisenovehiculoRepository;
import com.grupo3.Caso1.Model.Disenovehiculo;
import com.grupo3.Caso1.Service.Postgres.DisenovehiculoService;

@Service
public class DisenovehiculoServiceImp extends GenericServiceImp<Disenovehiculo, Long> implements DisenovehiculoService{

	@Autowired
	private DisenovehiculoRepository disenoImp; 
	@Override
	public CrudRepository<Disenovehiculo, Long> getDao() {
		// TODO Auto-generated method stub
		return disenoImp;
	}

}
