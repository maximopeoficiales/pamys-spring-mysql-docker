package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.ClientService;
import com.idat.proyect.persistence.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

// @CrossOrigin(origins="*")
@RestController
@RequestMapping("/client")
public class ClientController {
     @Autowired
     private ClientService clientService;

     @GetMapping("/all")
     @ApiOperation("Get all clients")
     @ApiResponse(code = 200, message = "OK")
     public ResponseEntity<List<Client>> getAll() {
          return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
     }

     @GetMapping("/{id}")
     @ApiOperation("Search a client with a ID")
     @ApiResponses({ @ApiResponse(code = 200, message = "OK"),
               @ApiResponse(code = 404, message = "Product not found") })
     public ResponseEntity<Client> getById(
               @ApiParam(value = "The id of the client", required = true, example = "5") @PathVariable("id") int idClient) {
          // si no existe un producto retorna un NOT_FOUND
          return clientService.getClient(idClient).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }

     @PostMapping
     @ApiOperation("Save a Client")
     @ApiResponse(code = 201, message = "OK")
     public ResponseEntity<Client> save(@RequestBody Client client) {
          return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
     }

     @PutMapping
     @ApiOperation("Update a Client")
     @ApiResponse(code = 201, message = "OK")
     public ResponseEntity<Client> update(@RequestBody Client client) {

          Client currentClient = clientService.getClient(client.getIdClient()).map(Client -> {
               return Client;
          }).orElse(null);
          currentClient.setAddress(client.getAddress());
          currentClient.setPhone(client.getPhone());
          currentClient.setFirstName(client.getFirstName());
          currentClient.setLastName(client.getLastName());
          return new ResponseEntity<>(clientService.save(currentClient), HttpStatus.CREATED);
     }

     @DeleteMapping("/{id}")
     @ApiOperation("Delete a Client by ID")
     @ApiResponse(code = 201, message = "OK")
     public ResponseEntity<?> delete(
               @ApiParam(value = "The id of the client", required = true, example = "1") @PathVariable("id") int idClient) {
          return (clientService.delete(idClient)) ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
}