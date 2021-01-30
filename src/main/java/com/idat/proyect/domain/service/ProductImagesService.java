package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.ProductImagesRepository;
import com.idat.proyect.persistence.entity.ProductImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImagesService {
    @Autowired
    private ProductImagesRepository productImagesRespository;

    public List<ProductImages> getAll() {
        return (List<ProductImages>) productImagesRespository.getAll();
    }

    public Optional<ProductImages> getProductImages(int idProductImages) {
        return productImagesRespository.getProductImages(idProductImages);
    }

    public Optional<List<ProductImages>> getIdProduct(int idProduct) {
        return productImagesRespository.getIdProduct(idProduct);
    }

    public ProductImages save(ProductImages ProductImages) {
        return productImagesRespository.save(ProductImages);
    }

    public boolean delete(int idProductImages) {
        return productImagesRespository.getProductImages(idProductImages).map(productImages -> {
            productImagesRespository.delete(idProductImages);
            return true;
        }).orElse(false);
    }
}
