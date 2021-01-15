package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.ClientService;
import com.idat.proyect.domain.service.ProductService;
import com.idat.proyect.persistence.entity.Client;
import com.idat.proyect.persistence.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

// @CrossOrigin(origins="*")
@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    @PostMapping("/client")
    @ApiOperation("Save a Client")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @GetMapping("/product")
    @ApiOperation("Get all products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
}
