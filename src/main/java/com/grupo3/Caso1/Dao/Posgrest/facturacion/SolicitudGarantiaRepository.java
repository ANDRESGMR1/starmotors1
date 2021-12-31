package com.grupo3.Caso1.Dao.Posgrest.facturacion;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo3.Caso1.Model.Factura;
import com.grupo3.Caso1.Model.MisVehiculos;
import com.grupo3.Caso1.Model.SolicitudGarantia;

public interface SolicitudGarantiaRepository extends JpaRepository<SolicitudGarantia, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE SolicitudGarantia set estado_solicitud=false WHERE id_solicitud=:id")
	public void cambiarEstadoReclamo(@Param("id") Long id);

	@Query(value = "SELECT v.chasis, a.links_imagen,l.marca,l.modelo\r\n"
			+ "		FROM vehiculo v, detallefactura d, factura f, client c, vehiculo_catalogo a, disenovehiculo l\r\n"
			+ "		where c.cedula_client=:id and c.cedula_client=f.cliente_cedula_client and f.\"id\"=d.factura_id\r\n"
			+ "		and v.chasis=d.vehiculo_chasis\r\n"
			+ "		and v.vehiculo_catalogo_id_vehiculo_catalogo=a.id_vehiculo_catalogo and a.id_diseno=l.id_diseno", nativeQuery = true)
	public List<String> listCarsByCedula(@Param("id") String id);

}
