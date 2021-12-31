package com.grupo3.Caso1.Dao.Posgrest;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo3.Caso1.Model.GarantiaVehiculo;

public interface GaratiaVehiculoRepositorio extends JpaRepository<GarantiaVehiculo, Long> {
	@Transactional
	@Modifying
	@Query("UPDATE GarantiaVehiculo set estado=false WHERE idGarantia=:id")
	public void cambiarEstadoReclamo(@Param("id") Long id);

}
