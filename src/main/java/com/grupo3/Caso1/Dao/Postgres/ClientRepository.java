package com.grupo3.Caso1.Dao.Postgres;

import com.grupo3.Caso1.Model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {

}