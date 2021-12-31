package com.grupo3.Caso1.Service.Posgrest.ServiceImp.OrdenReparacion;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.ordenReparacion.ordenRepCuerpoRepo;
import com.grupo3.Caso1.Mappers.TallerMapper;
import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCuerpo;
import com.grupo3.Caso1.Service.Posgrest.ordenReparacion.ordenRepCuerpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ordenRepaCuerpoServiceImp extends GenericServiceImp<ordenRepCuerpo, Long>
        implements ordenRepCuerpoService {

    @Autowired
    private ordenRepCuerpoRepo ordenRepCuerpoRepo;

    @Override
    public CrudRepository<ordenRepCuerpo, Long> getDao() {
        // TODO Auto-generated method stub
        return ordenRepCuerpoRepo;
    }

    public ordenRepCuerpo update(ordenRepCuerpo ordenRepCuerpo, Long id) {
        if (ordenRepCuerpoRepo.findById(id) != null) {
            return ordenRepCuerpoRepo.save(ordenRepCuerpo);
        } else {
            return null;
        }
    }

    public Map<String, Object> getOrdenById(Long id) {
        return TallerMapper.mappOrden(ordenRepCuerpoRepo.getById(id));
    }

    public Map<String, Object> cambiarEstadoOrdenById(Long id, String estado) {

        Map<String, Object> respuesta = new HashMap<>();

        Optional<ordenRepCuerpo> ordenBD = ordenRepCuerpoRepo.findById(id);
        ordenRepCuerpo orden = ordenBD.get();
        respuesta.put("oldValue", orden.getEstadoOrden());
        orden.setEstadoOrden(estado);

        this.update(ordenBD.get(), id);

        respuesta.put("newValue", orden.getEstadoOrden());
        respuesta.put("status", "success");

        return respuesta;
    }

    public void ordenEstadoUpdate(Long id) {
        ordenRepCuerpoRepo.updateordenrepuesto(id);
    }
}
