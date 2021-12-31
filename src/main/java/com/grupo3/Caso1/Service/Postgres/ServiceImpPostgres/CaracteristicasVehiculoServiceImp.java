package com.grupo3.Caso1.Service.Postgres.ServiceImpPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Postgres.CaracteristicaVehiculoRepository;
import com.grupo3.Caso1.Model.CaracteristicaVehiculo;
import com.grupo3.Caso1.Service.Postgres.caracteristicas_vehiculoService;

@Service
public class CaracteristicasVehiculoServiceImp extends GenericServiceImp<CaracteristicaVehiculo, Long> implements caracteristicas_vehiculoService {
	
	@Autowired
	private CaracteristicaVehiculoRepository caracteristicaVehi;
	
	@Override
	public CrudRepository<CaracteristicaVehiculo, Long> getDao() {
		// TODO Auto-generated method stub
		return caracteristicaVehi;
	}

}
