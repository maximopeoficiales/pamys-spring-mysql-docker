package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.ProductImagesService;
import com.idat.proyect.persistence.entity.ProductImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product_images")
public class ProductImagesController {
    @Autowired
    private ProductImagesService productImagesService;

    @GetMapping("/all")
    @ApiOperation("Get all images products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ProductImages>> getAll() {
        return new ResponseEntity<>(productImagesService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product image with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Product not found") })
    public ResponseEntity<ProductImages> getById(
            @ApiParam(value = "The id of the product", required = true, example = "5") @PathVariable("id") int idProductImages) {
        // si no existe un producto retorna un NOT_FOUND
        return productImagesService.getProductImages(idProductImages).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Product Image")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<ProductImages> save(@RequestBody ProductImages productImages) {
        return new ResponseEntity<>(productImagesService.save(productImages), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Product Image")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<ProductImages> update(@RequestBody ProductImages productImages) {

        ProductImages currentProductImages = productImagesService.getProductImages(productImages.getIdProductImages())
                .map(ProductImages -> {
                    return ProductImages;
                }).orElse(null);
        // currentProductImages.setIdProduct(productImages.getIdProduct());
        currentProductImages.setUrl(productImages.getUrl());
        return new ResponseEntity<>(productImagesService.save(currentProductImages), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Product by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the product image", required = true, example = "1") @PathVariable("id") int idProductImage) {
        return (productImagesService.delete(idProductImage)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
