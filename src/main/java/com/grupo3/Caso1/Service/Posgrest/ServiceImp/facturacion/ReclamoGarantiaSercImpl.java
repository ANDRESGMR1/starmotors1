package com.grupo3.Caso1.Service.Posgrest.ServiceImp.facturacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.facturacion.ReclamoGarantiaRepository;
import com.grupo3.Caso1.Model.ReclamoGarantia;
import com.grupo3.Caso1.Service.Posgrest.ReclamoGarantiaService;

@Service
public class ReclamoGarantiaSercImpl extends GenericServiceImp<ReclamoGarantia, Long> 
implements ReclamoGarantiaService{

	@Autowired
	private ReclamoGarantiaRepository garantiaRepository;
	@Override
	public CrudRepository<ReclamoGarantia, Long> getDao() {
		// TODO Auto-generated method stub
		return garantiaRepository;
	}
	
	public void cambiarEstadoReclamo(Long id) {
		garantiaRepository.cambiarEstadoReclamo(id);
	}

}
