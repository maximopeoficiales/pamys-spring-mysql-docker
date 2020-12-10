package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.ProductImages;

import org.springframework.data.repository.CrudRepository;

public interface IProductImagesCR extends CrudRepository<ProductImages, Integer> {
     Optional<List<ProductImages>> findByIdProduct(Integer idProduct);
}
