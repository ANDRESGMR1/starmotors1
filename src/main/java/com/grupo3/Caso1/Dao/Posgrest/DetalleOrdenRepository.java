package com.grupo3.Caso1.Dao.Posgrest;

import com.grupo3.Caso1.Model.ordenReparacion.DetalleRepuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleOrdenRepository extends JpaRepository<DetalleRepuestos, Long> {

    @Query("select d from DetalleRepuestos d where d.orden.idordenCuerpo = :ordenId")
    List<DetalleRepuestos> getDetalleRepuestosByIdOrden(@Param("ordenId") Long ordenId);

}
