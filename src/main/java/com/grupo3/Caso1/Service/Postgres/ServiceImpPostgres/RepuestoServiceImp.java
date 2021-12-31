package com.grupo3.Caso1.Service.Postgres.ServiceImpPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Postgres.RepuestoRepository;
import com.grupo3.Caso1.Model.Repuestos;
import com.grupo3.Caso1.Service.Postgres.RepuestoService;


@Service
public class RepuestoServiceImp extends GenericServiceImp<Repuestos, Long> implements RepuestoService {

	@Autowired
	private RepuestoRepository repuestoRep;
	
	@Override
	public CrudRepository<Repuestos, Long> getDao() {
		
		return repuestoRep;
	}
	

}
