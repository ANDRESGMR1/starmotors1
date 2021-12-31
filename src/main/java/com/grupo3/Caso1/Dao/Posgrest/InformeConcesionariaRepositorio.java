package com.grupo3.Caso1.Dao.Posgrest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo3.Caso1.Model.InformeConcecionaria;

public interface InformeConcesionariaRepositorio extends JpaRepository <InformeConcecionaria, Long> {
	@Query(value ="select sum(precio) AS TOTAL \r\n"
			+ "			 from detalle_repuestos, repuestos,orden_rep_cuerpo\r\n"
			+ "			 where detalle_repuestos.repuesto_id= repuestos.id_repuesto\r\n"
			+ "			 and orden_rep_cuerpo.idorden_cuerpo=detalle_repuestos.orden_id\r\n"
			+ "			 and detalle_repuestos.orden_id=:id", nativeQuery = true)
	public Double precio (@Param("id") Long id);
	
	@Query(value ="select costo_mano_obra  \r\n"
			+ "				from orden_rep_cuerpo,orden_rep_cavecera,detalle_repuestos\r\n"
			+ "		 		where  orden_rep_cuerpo.idorden_cuerpo=detalle_repuestos.orden_id\r\n"
			+ "				and 	orden_rep_cavecera.idorden_cave=orden_rep_cuerpo.idorden_cave\r\n"
			+ "				and detalle_repuestos.orden_id=:id\r\n"
			+ "				group by costo_mano_obra", nativeQuery = true)
	public Double costo(@Param("id") Long id);
	
	@Query(value ="						  			\r\n"
			+ "select   idorden_cuerpo\r\n"
			+ "				from orden_rep_cuerpo,orden_rep_cavecera,detalle_repuestos\r\n"
			+ "		 		where  orden_rep_cuerpo.idorden_cuerpo=detalle_repuestos.orden_id\r\n"
			+ "				and 	orden_rep_cavecera.idorden_cave=orden_rep_cuerpo.idorden_cave\r\n"
			+ "				and detalle_repuestos.orden_id=:id\r\n"
			+ "				group by idorden_cuerpo", nativeQuery = true)
	public int id(@Param("id") Long id);

}
