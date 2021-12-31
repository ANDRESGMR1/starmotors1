package com.grupo3.Caso1.Service.Posgrest.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.DetalleGarantiaRepositorio;
import com.grupo3.Caso1.Model.DetalleGarantia;
import com.grupo3.Caso1.Service.Posgrest.DetalleGarantiaService;
@Service
public class DetalleGarantiaServiceImp extends GenericServiceImp<DetalleGarantia, Long> implements DetalleGarantiaService {

	@Autowired
	DetalleGarantiaRepositorio detalle;
	
	@Override
	public CrudRepository<DetalleGarantia, Long> getDao() {
		// TODO Auto-generated method stub
		return detalle;
	}

}
