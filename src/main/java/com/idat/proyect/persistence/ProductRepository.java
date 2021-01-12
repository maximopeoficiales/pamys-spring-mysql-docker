package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IProductRepository;
import com.idat.proyect.persistence.crud.IProductCR;
import com.idat.proyect.persistence.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository {
     @Autowired
     private IProductCR crud;

     @Override
     public List<Product> getAll() {
          return (List<Product>) crud.findAll();
     }

     @Override
     public Optional<List<Product>> getIdCategory(int idCategory) {
          return crud.findByIdCategory(idCategory);
     }

     @Override
     public Optional<List<Product>> getIdVendor(int idVendor) {
          return crud.findByIdVendor(idVendor);
     }

     @Override
     public Optional<Product> getProduct(int idProduct) {
          return crud.findById(idProduct);
     }

     @Override
     public Product save(Product product) {
          return crud.save(product);
     }

     @Override
     public void delete(int productId) {
          crud.deleteById(productId);
     }

     @Override
     public Optional<List<Product>> getByName(String nameProduct) {
          return crud.findByNameLike("%" + nameProduct + "%");
     }

}
