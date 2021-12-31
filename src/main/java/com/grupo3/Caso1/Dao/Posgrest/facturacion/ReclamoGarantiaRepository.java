package com.grupo3.Caso1.Dao.Posgrest.facturacion;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo3.Caso1.Model.ReclamoGarantia;

public interface ReclamoGarantiaRepository extends JpaRepository<ReclamoGarantia, Long>{

	@Transactional
	@Modifying
	@Query("UPDATE ReclamoGarantia set estado_reclamo=false WHERE id_reclamo=:id")
	public void cambiarEstadoReclamo(@Param("id") Long id);

}
