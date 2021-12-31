package com.grupo3.Caso1.Dao.Postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.Caso1.Model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
	
	@Query("select f from Factura f join fetch f.cliente c where c.cedulaClient=?1")
	public List<Factura> findFacturaByClienteCedulaClient(String cedulaClient);
	

}
