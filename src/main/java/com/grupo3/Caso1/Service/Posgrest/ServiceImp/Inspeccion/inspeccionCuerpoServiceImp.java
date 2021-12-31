package com.grupo3.Caso1.Service.Posgrest.ServiceImp.Inspeccion;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.Inspeccion.inspecCuerpoRepo;
import com.grupo3.Caso1.Model.Inspeccion.inspeCuerpo;
import com.grupo3.Caso1.Service.Posgrest.Inspeccion.inspeCuerpoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class inspeccionCuerpoServiceImp extends GenericServiceImp<inspeCuerpo, Long> implements inspeCuerpoService {

    @Autowired
    private inspecCuerpoRepo inspecCuerpoRepo;

    @Override
    public CrudRepository<inspeCuerpo, Long> getDao() {
        // TODO Auto-generated method stub
        return inspecCuerpoRepo;
    }

    public inspeCuerpo update(inspeCuerpo inspeCuerpo) {
        // if (inspecCuerpoRepo.findById(id) != null) {
        return inspecCuerpoRepo.save(inspeCuerpo);
        // } else {
        // return null;
        // }
    }

}
