package com.grupo3.Caso1.Service.Postgres.ServiceImpPostgres;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Postgres.ClientRepository;
import com.grupo3.Caso1.Model.Client;
import com.grupo3.Caso1.Service.Postgres.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp extends GenericServiceImp<Client, String> implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public CrudRepository<Client, String> getDao() {
        return clientRepository;
    }

}