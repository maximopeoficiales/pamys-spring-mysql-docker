package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Client;

import org.springframework.data.repository.CrudRepository;

public interface IClientCR extends CrudRepository<Client, Integer> {
     Optional<List<Client>> findByIdRole(Integer idRole);

     Optional<List<Client>> findByUsername(Integer idRole);

     Optional<List<Client>> findByEmail(Integer idRole);
}
