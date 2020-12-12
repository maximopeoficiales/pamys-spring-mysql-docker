package com.idat.proyect.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.ClientRepository;
import com.idat.proyect.persistence.entity.Client;
import com.idat.proyect.web.security.EncriptarPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
     @Autowired
     private ClientRepository clientRepository;

     public List<Client> getAll() {
          List<Client> clients = new ArrayList<Client>();
          clientRepository.getAll().forEach(client -> {
               client.setPassword(client.getPassword().replace("{bcrypt}", ""));
               clients.add(client);
          });
          return clients;
     }

     public Optional<Client> getClient(int idClient) {
          return clientRepository.getClient(idClient);
     }

     public Optional<Client> getUsername(String username) {
          return clientRepository.getUsername(username);
     }

     public Optional<Client> getEmail(String email) {
          return clientRepository.getEmail(email);
     }

     public Client save(Client client) {
          client.setPassword("{bcrypt}" + EncriptarPassword.encriptarPassword(client.getPassword()));
          return clientRepository.save(client);
     }

     public boolean delete(int idClient) {
          return getClient(idClient).map(Client -> {
               clientRepository.delete(idClient);
               return true;
          }).orElse(false);
     }
}
