package com.idat.proyect.persistence.crud;

import java.util.Optional;

import com.idat.proyect.persistence.entity.Role;

import org.springframework.data.repository.CrudRepository;

public interface IRoleCR extends CrudRepository<Role, Integer> {
}
