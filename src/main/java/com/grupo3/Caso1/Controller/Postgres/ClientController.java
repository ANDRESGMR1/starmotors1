package com.grupo3.Caso1.Controller.Postgres;

import java.util.List;

import com.grupo3.Caso1.Commons.Encrypt;
import com.grupo3.Caso1.Model.Client;
import com.grupo3.Caso1.Service.Postgres.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente/api/v1")
@CrossOrigin("*")
public class ClientController {
    // Este apartado hara lo todo lo que necesite para cada metodo

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Client find(@PathVariable String id) {
        return clientService.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client obj = clientService.save(client);
        return new ResponseEntity<Client>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Client> delete(@PathVariable String id) {
        Client client = clientService.get(id);
        if (client != null) {
            clientService.delete(id);
        } else {
            return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public Client login(@RequestParam("cedulaClient") String id,
            @RequestParam("passwordClient") String password) {
        Client client = clientService.get(id);
        System.out.println(new Encrypt().getAESDecrypt(client.getPasswordClient()));
        if (client != null) {
            if (new Encrypt().getAESDecrypt(client.getPasswordClient()).equals(new Encrypt().getAESDecrypt(password))) {
                return client;
            }
        }
        return null;
    }

    @PostMapping(value = "/edit-pass")
    public ResponseEntity<Client> EditPass(@RequestBody Client client) {
        String passEncryp = new Encrypt().getAES(client.getPasswordClient());
        client.setPasswordClient(passEncryp);
        Client obj = clientService.save(client);
        return new ResponseEntity<Client>(obj, HttpStatus.OK);
    }

}