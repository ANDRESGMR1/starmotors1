package com.grupo3.Caso1.Service.Posgrest.ServiceImp.Inspeccion;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.Inspeccion.inspeCaveceraRepo;
import com.grupo3.Caso1.Model.Inspeccion.inspeCavecera;
import com.grupo3.Caso1.Service.Posgrest.Inspeccion.inspeCaveceraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class inspeccionCaveceraServiceImp extends GenericServiceImp<inspeCavecera, Long>
        implements inspeCaveceraService {

    @Autowired
    private inspeCaveceraRepo inspeCaveceraRepo;

    @Override
    public CrudRepository<inspeCavecera, Long> getDao() {
        // TODO Auto-generated method stub
        return inspeCaveceraRepo;
    }

    public inspeCavecera update(inspeCavecera inspeCavecera, Long id) {
        if (inspeCaveceraRepo.findById(id) != null) {
            return inspeCaveceraRepo.save(inspeCavecera);
        } else {
            return null;
        }
    }

}
