package com.grupo3.Caso1.Dao.Postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo3.Caso1.Model.CaracteristicaVehiculo;
import com.grupo3.Caso1.Model.Repuestos;

public interface CaracteristicaVehiculoRepository  extends JpaRepository<CaracteristicaVehiculo, Long>{

}
