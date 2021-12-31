package com.grupo3.Caso1.Service.Posgrest;

import java.util.List;

import com.grupo3.Caso1.Commons.GenericService;
import com.grupo3.Caso1.Model.Vehiculo;

public interface VehiculoService extends GenericService<Vehiculo, String> {
	public List<Vehiculo> findAllEstadoFalse();
	public List<Vehiculo> findAllByMarcaOrModeloAndEstado(String marcaOrModelo);
	public Vehiculo findVehiculoByIdVehiculoCatalogo(Integer id);
}
