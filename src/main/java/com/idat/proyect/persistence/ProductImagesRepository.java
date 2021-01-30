package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IProductImagesRepository;
import com.idat.proyect.persistence.crud.IProductImagesCR;
import com.idat.proyect.persistence.entity.ProductImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImagesRepository implements IProductImagesRepository {

    @Autowired
    private IProductImagesCR crud;

    @Override
    public List<ProductImages> getAll() {
        return (List<ProductImages>) crud.findAll();
    }

    @Override
    public Optional<ProductImages> getProductImages(int idProductImages) {
        return crud.findById(idProductImages);
    }

    @Override
    public Optional<List<ProductImages>> getIdProduct(int idProduct) {
        return crud.findByIdProduct(idProduct);
    }

    @Override
    public ProductImages save(ProductImages ProductImages) {
        return crud.save(ProductImages);
    }

    @Override
    public void delete(int idProductImages) {
        crud.deleteById(idProductImages);
    }

}
