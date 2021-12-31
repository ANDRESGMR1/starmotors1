package com.grupo3.Caso1.Dao.Postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo3.Caso1.Model.Cotizacion;

public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {

}
