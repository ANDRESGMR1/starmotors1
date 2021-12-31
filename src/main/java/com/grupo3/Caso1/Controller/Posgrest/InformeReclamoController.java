package com.grupo3.Caso1.Controller.Posgrest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

import com.grupo3.Caso1.Model.InformeReclamo;
import com.grupo3.Caso1.Service.Posgrest.InformeReclamoService;
import com.grupo3.Caso1.Service.Posgrest.ServiceImp.InformeReclamoServiceImp;

import org.h2.security.auth.DefaultAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inforech/api/v1")
@CrossOrigin("*")
public class InformeReclamoController {
    @Autowired
    private InformeReclamoService informeRechazoService;
    @Autowired
    private InformeReclamoServiceImp inforservice2;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @GetMapping(value = "/all")
    public List<InformeReclamo> getAll() {
        return informeRechazoService.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public InformeReclamo find(@PathVariable(value = "id") Long id) {
        return informeRechazoService.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<InformeReclamo> save(@RequestBody InformeReclamo informeRechazo) {
        username = "comercializadora787@gmail.com";
        password = "mjCPhcmmgU2Xb2w";
        InformeReclamo obj = informeRechazoService.save(informeRechazo);
        return new ResponseEntity<InformeReclamo>(obj, HttpStatus.OK);
    }

    @RequestMapping("/email/{cavecera}/{mensaje}/{destinatario}")
    public ResponseEntity<?> envioemail(@PathVariable(name = "mensaje") String mensaje,
            @PathVariable(name = "cavecera") String cavecera, @PathVariable(name = "destinatario") String destinatario)
            throws Exception {
        inforservice2.sendMail(destinatario, mensaje, cavecera);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<InformeReclamo> delete(@PathVariable(value = "id") Long id) {
        InformeReclamo informeRechazo = informeRechazoService.get(id);
        if (informeRechazo != null) {
            informeRechazoService.delete(id);
        } else {
            return new ResponseEntity<InformeReclamo>(HttpStatus.OK);
        }
        return new ResponseEntity<InformeReclamo>(informeRechazo, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<InformeReclamo> update(@RequestBody InformeReclamo informeReclamo,
            @PathVariable(name = "id") Long id) {
        inforservice2.update(informeReclamo, id);
        if (informeReclamo != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/aceptado/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> respuestaClienteAcep(@PathVariable("id") Long id) {
        inforservice2.cambiarRespuestaClientAcept(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/rechazado/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> respuestaClienteCancel(@PathVariable("id") Long id) {
        inforservice2.cambiarRespuestaClientCancel(id);
        System.out.println(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
