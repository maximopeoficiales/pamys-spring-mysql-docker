package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Client;

public interface IClientRepository {
     List<Client> getAll();

     Optional<Client> getClient(int idClient);

     Optional<List<Client>> getIdRole(int idRole);

     Optional<List<Client>> getUsername(int username);

     Optional<List<Client>> getEmail(int email);

     Client save(Client Client);

     void delete(int idClient);
}
