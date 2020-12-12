package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Client;

import org.springframework.data.repository.CrudRepository;

public interface IClientCR extends CrudRepository<Client, Integer> {
     Optional<List<Client>> findByUsername(String username);

     Optional<List<Client>> findByEmail(String email);
}
