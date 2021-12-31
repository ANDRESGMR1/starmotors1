package com.grupo3.Caso1.Dao.Posgrest.ordenReparacion;

import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCavecera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ordenRepCaveceraRepo extends JpaRepository<ordenRepCavecera, Long> {

}
