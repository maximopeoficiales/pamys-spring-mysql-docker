package com.idat.proyect.web.controller;

import com.idat.proyect.domain.service.ClientService;
import com.idat.proyect.persistence.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/clients/save")
    @ApiOperation("Save a Client")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }
}
