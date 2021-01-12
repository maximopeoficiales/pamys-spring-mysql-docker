package com.idat.proyect.persistence.crud;

import java.util.Optional;

import com.idat.proyect.persistence.entity.Client;

import org.springframework.data.repository.CrudRepository;

public interface IClientCR extends CrudRepository<Client, Integer> {
     Optional<Client> findByUsername(String username);

     // @Query(value = "SELECT u FROM client where u.username = 1?", nativeQuery = true)
     // Client findByUsername2(String username);

     Optional<Client> findByEmail(String email);
}
