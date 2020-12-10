package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Role;

public interface IRoleRepository {
     List<Role> getAll();

     Optional<Role> getRole(int idRole);

     Role save(Role Role);

     void delete(int idRole);
}
