package com.idat.proyect.web.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.idat.proyect.domain.service.ProductService;
import com.idat.proyect.environments.Enviroments;
import com.idat.proyect.persistence.entity.Product;
import com.idat.proyect.web.utilities.PhotoOperations;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// @CrossOrigin(origins="*")
@RestController
@RequestMapping("/product")
public class ProductController {
     @Autowired
     private PhotoOperations photoOperationsService;

     @Autowired
     private Enviroments env;

     @Autowired
     private ProductService productService;

     @GetMapping("/all")
     @ApiOperation("Get all supermarket products")
     @ApiResponse(code = 200, message = "OK")
     public ResponseEntity<List<Product>> getAll() {
          return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
     }

     @GetMapping("/{id}")
     @ApiOperation("Search a product with a ID")
     @ApiResponses({ @ApiResponse(code = 200, message = "OK"),
               @ApiResponse(code = 404, message = "Product not found") })
     public ResponseEntity<Product> getById(
               @ApiParam(value = "The id of the product", required = true, example = "5") @PathVariable("id") int idProduct) {
          // si no existe un producto retorna un NOT_FOUND
          return productService.getProduct(idProduct).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }

     @GetMapping("/slug/{slug}")
     @ApiOperation("Search a product with a slug")
     @ApiResponses({ @ApiResponse(code = 200, message = "OK"),
               @ApiResponse(code = 404, message = "Product not found") })
     public ResponseEntity<Product> getBySlug(
               @ApiParam(value = "The slug of the product", required = true, example = "product-slug-example") @PathVariable("slug") String slug) {
          // si no existe un producto retorna un NOT_FOUND
          return productService.getBySlug(slug).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }

     @GetMapping("/search/{name}")
     @ApiOperation("Search a product with your name Company")
     @ApiResponses({ @ApiResponse(code = 200, message = "OK"),
               @ApiResponse(code = 404, message = "Product not found") })
     public ResponseEntity<List<Product>> getByName(
               @ApiParam(value = "Product Name", required = true, example = "zapato") @PathVariable("name") String name) {
          // si no existe un producto retorna un NOT_FOUND
          return productService.getByName(name).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }

     @PostMapping
     @ApiOperation("Save a Product")
     @ApiResponse(code = 201, message = "OK")
     public ResponseEntity<Product> save(@RequestBody Product product) {
          Date in = new Date();
          LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
          product.setDateCreated(ldt);
          return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
     }

     @PutMapping
     @ApiOperation("Update a Product")
     @ApiResponse(code = 201, message = "OK")
     public ResponseEntity<Product> update(@RequestBody Product product) {

          Product currentProduct = productService.getProduct(product.getIdProduct()).map(Product -> {
               return Product;
          }).orElse(null);
          currentProduct.setDescription(product.getDescription());
          currentProduct.setSku(product.getSku());
          currentProduct.setIdVendor(product.getIdVendor());
          currentProduct.setIdCategory(product.getIdCategory());
          currentProduct.setName(product.getName());
          currentProduct.setPrice(product.getPrice());
          currentProduct.setSalePrice(product.getSalePrice());
          currentProduct.setStock(product.getStock());
          // currentProduct.setThumbnailUrl(product.getThumbnailUrl());
          return new ResponseEntity<>(productService.save(currentProduct), HttpStatus.CREATED);
     }

     @DeleteMapping("/{id}")
     @ApiOperation("Delete a Product by ID")
     @ApiResponse(code = 201, message = "OK")
     public ResponseEntity<?> delete(
               @ApiParam(value = "The id of the product", required = true, example = "1") @PathVariable("id") int idProduct) {
          return (productService.delete(idProduct)) ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

     // subir imagen
     @PostMapping("/photos/upload")
     public ResponseEntity<Product> uploadPhotoProduct(@RequestParam("imgFile") MultipartFile file,
               @RequestParam("idProduct") Integer idProduct) {

          Product product = productService.getProduct(idProduct).map(e -> {
               return e;
          }).orElse(null);
          // si el archivo no esta vacio y si existe un product
          if (!file.isEmpty() && product != null) {
               // genera identificador unico
               String fileName = null;
               try {
                    fileName = this.photoOperationsService.copyPhoto(file,
                              this.env.nameDirectoryProductsThumbnailPhotos);
               } catch (IOException e) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
               }
               // antes de guardar eliminamos la foto existente
               this.photoOperationsService.removePhoto(product.getThumbnailUrl(),
                         this.env.nameDirectoryProductsThumbnailPhotos);
               // guardo nueva foto
               product.setThumbnailUrl(fileName);
               var productUpload = productService.save(product);
               return new ResponseEntity<Product>(productUpload, HttpStatus.ACCEPTED);
          }
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

     }
}
