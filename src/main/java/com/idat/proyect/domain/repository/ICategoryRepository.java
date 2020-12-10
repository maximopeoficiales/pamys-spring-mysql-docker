package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Category;

public interface ICategoryRepository {
     List<Category> getAll();

     Optional<Category> getCategory(int idCategory);

     Category save(Category category);

     void delete(int idCategory);
}
