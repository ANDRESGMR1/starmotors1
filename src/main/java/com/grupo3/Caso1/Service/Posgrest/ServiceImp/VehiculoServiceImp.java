package com.grupo3.Caso1.Service.Posgrest.ServiceImp;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.VehiculoRepository;
import com.grupo3.Caso1.Model.SolicitudGarantia;
import com.grupo3.Caso1.Model.Vehiculo;
import com.grupo3.Caso1.Service.Posgrest.VehiculoService;

@Service
public class VehiculoServiceImp extends GenericServiceImp<Vehiculo, String> implements VehiculoService {

	@Autowired
	private VehiculoRepository vehiculo;

	@Override
	public CrudRepository<Vehiculo, String> getDao() {
		// TODO Auto-generated method stub
		return vehiculo;
	}

	public List<Vehiculo> findAllByEstado(Boolean estado){
		List<Vehiculo> solGaranrespuesta= new ArrayList<>();
		List<Vehiculo> solicitudes = vehiculo.findAll(); 
		for (int i=0; i<solicitudes.size();i++) {
			if(solicitudes.get(i).isEstado()==estado) {
				solGaranrespuesta.add(solicitudes.get(i));
			}
	   }
		return solGaranrespuesta;
   }

	public void cambiarEstadoSolicitud(String id) {
		vehiculo.cambiarEstadoVehiculo(id);
	
}

	@Override
	public List<Vehiculo> findAllEstadoFalse() {
		return vehiculo.findAllEstadoFalse();
	}

	//PARA  SELECIONAR EL VEHICULO Y REALIZAR LA VENTA
	@Override
	public List<Vehiculo> findAllByMarcaOrModeloAndEstado(String marcaOrModelo) {
		return vehiculo.findAllByMarcaOrModeloAndEstado(marcaOrModelo);
	}
	@Override
	public Vehiculo findVehiculoByIdVehiculoCatalogo(Integer id) {
		return vehiculo.findVehiculoByIdVehiculoCatalogo(id);
	}


}
