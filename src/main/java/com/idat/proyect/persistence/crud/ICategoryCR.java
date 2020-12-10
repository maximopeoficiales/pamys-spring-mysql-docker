package com.idat.proyect.persistence.crud;

import com.idat.proyect.persistence.entity.Category;

import org.springframework.data.repository.CrudRepository;

public interface ICategoryCR extends CrudRepository<Category, Integer> {
     
}
