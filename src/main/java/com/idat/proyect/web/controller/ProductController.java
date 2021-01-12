package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.ProductService;
import com.idat.proyect.persistence.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

// @CrossOrigin(origins="*")
@RestController
@RequestMapping("/product")
public class ProductController {
     @Autowired
     private ProductService productService;

     @GetMapping("/all")
     @ApiOperation("Get all supermarket products")
     @ApiResponse(code = 200, message = "OK")
     public ResponseEntity<List<Product>> getAll() {
          return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
     }
}
