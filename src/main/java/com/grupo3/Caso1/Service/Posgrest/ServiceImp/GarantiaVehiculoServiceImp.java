package com.grupo3.Caso1.Service.Posgrest.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.GaratiaVehiculoRepositorio;
import com.grupo3.Caso1.Dao.Posgrest.VehiculoRepository;
import com.grupo3.Caso1.Model.GarantiaVehiculo;
import com.grupo3.Caso1.Service.Posgrest.GarantiaVehiculoService;
@Service
public class GarantiaVehiculoServiceImp  extends GenericServiceImp<GarantiaVehiculo, Long> implements GarantiaVehiculoService{

	@Autowired
	private GaratiaVehiculoRepositorio vehiculo;
	
	@Override
	public CrudRepository<GarantiaVehiculo, Long> getDao() {
		// TODO Auto-generated method stub
		return vehiculo;
	}
	public void cambiarEstadoSolicitud(Long id) {
		vehiculo.cambiarEstadoReclamo(id);
	}


}
