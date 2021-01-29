package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.ProductImages;

public interface IProductImagesRepository {
     List<ProductImages> getAll();

     Optional<ProductImages> getProductImages(int idProductImages);
     Optional<List<ProductImages>> getIdProduct(int idProduct);

     ProductImages save(ProductImages ProductImages);

     void delete(int idProductImages);
}
