package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Client;

public interface IClientRepository {
     List<Client> getAll();

     Optional<Client> getClient(int idClient);

     Optional<Client> getUsername(String username);

     Optional<Client> getEmail(String email);

     Client save(Client client);

     void delete(int idClient);
}
