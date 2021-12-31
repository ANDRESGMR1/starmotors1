package com.grupo3.Caso1.Dao.Posgrest;

import javax.transaction.Transactional;

import com.grupo3.Caso1.Model.InformeReclamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface informeReclamoRepositori extends JpaRepository<InformeReclamo, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE InformeReclamo set respuestaCliente='ACEPTADO' WHERE idinformeRecha=:id")
    public void cambiarEstadoClienteAcep(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE InformeReclamo set respuestaCliente='RECHAZADO' WHERE idinformeRecha=:id")
    public void cambiarEstadoClienteCancel(@Param("id") Long id);

}
