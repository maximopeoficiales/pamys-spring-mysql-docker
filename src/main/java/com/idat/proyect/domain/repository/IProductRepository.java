package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Product;

public interface IProductRepository {
     List<Product> getAll();

     Optional<List<Product>> getIdCategory(int idCategory);

     Optional<List<Product>> getIdVendor(int idVendor);

     Optional<List<Product>> getByName(String nameProduct);

     Optional<Product> getProduct(int idProduct);

     Product save(Product product);

     void delete(int productId);
}
