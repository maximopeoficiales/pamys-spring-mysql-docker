package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IClientRepository;
import com.idat.proyect.persistence.crud.IClientCR;
import com.idat.proyect.persistence.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository implements IClientRepository {
// 
     @Autowired
     private IClientCR crud;

     @Override
     public List<Client> getAll() {
          return (List<Client>) crud.findAll();
     }

     @Override
     public Optional<Client> getClient(int idClient) {
          return crud.findById(idClient);
     }

     @Override
     public Optional<Client> getUsername(String username) {
          return crud.findByUsername(username);
     }

     @Override
     public Optional<Client> getEmail(String email) {
          return crud.findByEmail(email);
     }

     @Override
     public Client save(Client client) {
          // encripta el password
          return crud.save(client);
     }

     @Override
     public void delete(int idClient) {
          crud.deleteById(idClient);
     }

}
