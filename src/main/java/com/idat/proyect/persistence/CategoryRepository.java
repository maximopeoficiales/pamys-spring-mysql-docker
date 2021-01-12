package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.ICategoryRepository;
import com.idat.proyect.persistence.crud.ICategoryCR;
import com.idat.proyect.persistence.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository implements ICategoryRepository {
    @Autowired
    private ICategoryCR crud;

    @Override
    public List<Category> getAll() {
        return (List<Category>) crud.findAll();
    }

    @Override
    public Optional<Category> getCategory(int idCategory) {
        return crud.findById(idCategory);
    }

    @Override
    public Category save(Category category) {
        return crud.save(category);
    }

    @Override
    public void delete(int idCategory) {
        crud.deleteById(idCategory);
    }

}
