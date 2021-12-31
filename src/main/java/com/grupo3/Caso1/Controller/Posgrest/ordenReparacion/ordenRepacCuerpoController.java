package com.grupo3.Caso1.Controller.Posgrest.ordenReparacion;

import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCuerpo;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.OrdenReparacion.ordenRepaCuerpoServiceImp;
import com.grupo3.Caso1.Service.Posgrest.ordenReparacion.ordenRepCuerpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/ordecuerpo/api/v1")
@CrossOrigin("*")
public class ordenRepacCuerpoController {
    @Autowired
    public ordenRepCuerpoService ordenRepCuerpoService;
    @Autowired
    public ordenRepaCuerpoServiceImp ordenRepaCuerpoServiceImp2;

    @GetMapping(value = "/getall")
    public List<ordenRepCuerpo> getAll() {
        return ordenRepCuerpoService.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public ordenRepCuerpo find(@PathVariable(value = "id") Long id) {
        return ordenRepCuerpoService.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ordenRepCuerpo> save(@RequestBody ordenRepCuerpo ordenRepCuerpo) {
        ordenRepCuerpo obj = ordenRepCuerpoService.save(ordenRepCuerpo);
        return new ResponseEntity<ordenRepCuerpo>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ordenRepCuerpo> delete(@RequestParam(value = "id") Long id) {
        ordenRepCuerpo obj = ordenRepCuerpoService.get(id);
        if (obj != null) {
            ordenRepCuerpoService.delete(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<ordenRepCuerpo>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ordenRepCuerpo> update(@PathVariable(name = "id") Long id, @RequestBody ordenRepCuerpo ordenRepCuerpo) {
        if (ordenRepaCuerpoServiceImp2.update(ordenRepCuerpo, id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/orden-by-id/{id}")
    public Map<String, Object> getOrdenById(@PathVariable(name = "id") Long id) {
        return ordenRepaCuerpoServiceImp2.getOrdenById(id);
    }

    @PutMapping("/cambiar-estado-orden/{id}")
    public Map<String, Object> cambiarEstadoOrden(@PathVariable(name = "id") Long id, @RequestBody String estado) {
        return ordenRepaCuerpoServiceImp2.cambiarEstadoOrdenById(id, estado);
    }

    @RequestMapping(value = "/updatestadorep/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEstadoRep(@PathVariable(name = "id") Long id) {
        ordenRepaCuerpoServiceImp2.ordenEstadoUpdate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
