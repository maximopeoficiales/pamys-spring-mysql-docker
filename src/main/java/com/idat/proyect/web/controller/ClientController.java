package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.ClientService;
import com.idat.proyect.persistence.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/clients")
public class ClientController {
     @Autowired
     private ClientService clientService;

     @GetMapping("/all")
     @ApiOperation("Get all clients")
     @ApiResponse(code = 200, message = "OK")
     public ResponseEntity<List<Client>> getAll() {
          return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
     }
}
