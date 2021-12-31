package com.grupo3.Caso1.Dao.Posgrest.ordenReparacion;

import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCuerpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;
import javax.transaction.Transactional;

public interface ordenRepCuerpoRepo extends JpaRepository<ordenRepCuerpo, Long> {

    @Query("SELECT o FROM ordenRepCuerpo o WHERE o.estadoOrden = :estado ORDER BY o.ordenRepCavecera.fechaIngreso")
    List<ordenRepCuerpo> getOrdenesTaller(@Param("estado") String estado);

    @Transactional
    @Modifying
    @Query("UPDATE ordenRepCuerpo set estadoOrden='APROBADO' WHERE idordenCuerpo=:id")
    public void updateordenrepuesto(@Param("id") Long id);
}
