package com.grupo3.Caso1.Service.Posgrest.ServiceImp.OrdenReparacion;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.ordenReparacion.ordenRepCaveceraRepo;
import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCavecera;
import com.grupo3.Caso1.Service.Posgrest.ordenReparacion.ordenRepaCaveceraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ordenRepaCaveceraServiceImp extends GenericServiceImp<ordenRepCavecera, Long> implements ordenRepaCaveceraService {

    @Autowired
    private ordenRepCaveceraRepo ordenRepCaveceraRepo;

    @Override
    public CrudRepository<ordenRepCavecera, Long> getDao() {
        // TODO Auto-generated method stub
        return ordenRepCaveceraRepo;
    }

    public ordenRepCavecera update(ordenRepCavecera ordenRepCavecera, Long id) {
        if (ordenRepCaveceraRepo.findById(id) != null) {
            return ordenRepCaveceraRepo.save(ordenRepCavecera);
        } else {
            return null;
        }
    }

}
