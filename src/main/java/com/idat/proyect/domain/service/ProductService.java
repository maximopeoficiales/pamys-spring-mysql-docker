package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.ProductRepository;
import com.idat.proyect.persistence.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
     @Autowired
     private ProductRepository productRepository;

     public List<Product> getAll() {
          return productRepository.getAll();
     }

     public Optional<Product> getProduct(int productId) {
          return productRepository.getProduct(productId);
     }

     public Optional<List<Product>> getIdCategory(int categoryId) {
          return productRepository.getIdCategory(categoryId);
     }

     public Optional<List<Product>> getByName(String nameProduct) {
          return productRepository.getByName(nameProduct);
     }

     public Product save(Product product) {
          return productRepository.save(product);
     }

     public boolean delete(int productId) {
          return getProduct(productId).map(product -> {
               productRepository.delete(productId);
               return true;
          }).orElse(false);
     }
}
