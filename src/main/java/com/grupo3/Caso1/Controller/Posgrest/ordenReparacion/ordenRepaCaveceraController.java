package com.grupo3.Caso1.Controller.Posgrest.ordenReparacion;

import com.grupo3.Caso1.Model.ordenReparacion.ordenRepCavecera;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.OrdenReparacion.ordenRepaCaveceraServiceImp;
import com.grupo3.Caso1.Service.Posgrest.ordenReparacion.ordenRepaCaveceraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/ordencave/api/v1")
@CrossOrigin("*")
public class ordenRepaCaveceraController {
    @Autowired
    private ordenRepaCaveceraService ordenRepaCaveceraService;
    @Autowired
    private ordenRepaCaveceraServiceImp ordenRepaCaveceraServiceImp2;

    @GetMapping(value = "/all")
    public List<ordenRepCavecera> getall() {
        return ordenRepaCaveceraService.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public ordenRepCavecera find(@PathVariable(value = "id") Long id) {
        return ordenRepaCaveceraService.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ordenRepCavecera> save(@RequestBody ordenRepCavecera ordenRepCavecera) {
        ordenRepCavecera obj = ordenRepaCaveceraService.save(ordenRepCavecera);
        return new ResponseEntity<ordenRepCavecera>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ordenRepCavecera> delete(@PathVariable(value = "id") Long id) {
        ordenRepCavecera obj = ordenRepaCaveceraService.get(id);
        if (obj != null) {
            ordenRepaCaveceraService.delete(id);
        } else {
            return new ResponseEntity<ordenRepCavecera>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<ordenRepCavecera>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ordenRepCavecera> update(@RequestBody ordenRepCavecera ordenRepCavecera,
            @PathVariable(name = "id") Long id) {
        if (ordenRepaCaveceraServiceImp2.update(ordenRepCavecera, id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
