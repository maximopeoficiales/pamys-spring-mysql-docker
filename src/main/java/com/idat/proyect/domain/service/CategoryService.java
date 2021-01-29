package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.CategoryRepository;
import com.idat.proyect.persistence.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int idCategory) {
        return categoryRepository.getCategory(idCategory);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public boolean delete(int idCategory) {
        return getCategory(idCategory).map(Category -> {
            categoryRepository.delete(idCategory);
            return true;
        }).orElse(false);
    }
}
