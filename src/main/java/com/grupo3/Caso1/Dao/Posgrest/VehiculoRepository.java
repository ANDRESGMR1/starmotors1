package com.grupo3.Caso1.Dao.Posgrest;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;



import com.grupo3.Caso1.Model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {

	@Transactional
	@Modifying
	@Query("UPDATE Vehiculo set estado=false WHERE chasis=:id")
	public void cambiarEstadoVehiculo(@Param("id") String id);

	
	@Query("select v from Vehiculo v where v.estado=true ")
	public List<Vehiculo> findAllEstadoFalse();
	
	//PARA  SELECIONAR EL VEHICULO Y REALIZAR LA VENTA
	@Query( value = "select * from vehiculo v INNER JOIN vehiculo_catalogo vc on v.vehiculo_catalogo_id_vehiculo_catalogo=vc.id_vehiculo_catalogo INNER JOIN disenovehiculo d on vc.id_diseno=d.id_diseno where d.marca like %?1%  and v.estado=true",nativeQuery = true)
	public List<Vehiculo> findAllByMarcaOrModeloAndEstado(String marcaOrModelo);
	
	//PARA CARGAR EL VEHICULO COTIZADO EN LA VENTA
	@Query( value = "select * from vehiculo v INNER JOIN vehiculo_catalogo vc on v.vehiculo_catalogo_id_vehiculo_catalogo=vc.id_vehiculo_catalogo where v.vehiculo_catalogo_id_vehiculo_catalogo=?1 and v.estado=true",nativeQuery = true)
	public Vehiculo findVehiculoByIdVehiculoCatalogo(Integer id);

	

}
