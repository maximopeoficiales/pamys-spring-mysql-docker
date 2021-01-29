package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.VendorService;
import com.idat.proyect.persistence.entity.Vendor;

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
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket vendor")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Vendor>> getAll() {
        return new ResponseEntity<>(vendorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a vendor with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Product not found") })
    public ResponseEntity<Vendor> getById(
            @ApiParam(value = "The id of the vendor", required = true, example = "5") @PathVariable("id") int idVendor) {
        // si no existe un producto retorna un NOT_FOUND
        return vendorService.getVendor(idVendor).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search/{company}")
    @ApiOperation("Search a vendor with your name Company")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Vendor not found") })
    public ResponseEntity<List<Vendor>> getByCompany(
            @ApiParam(value = "Name company of the vendor", required = true, example = "Bata") @PathVariable("company") String company) {
        // si no existe un producto retorna un NOT_FOUND
        return vendorService.getByCompany(company).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Vendor")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Vendor> save(@RequestBody Vendor vendor) {
        return new ResponseEntity<>(vendorService.save(vendor), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Vendor")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Vendor> update(@RequestBody Vendor vendor) {

        Vendor currentVendor = vendorService.getVendor(vendor.getIdVendor()).map(Vendor -> {
            return Vendor;
        }).orElse(null);
        currentVendor.setCompany(vendor.getCompany());
        currentVendor.setDescription(vendor.getDescription());
        return new ResponseEntity<>(vendorService.save(currentVendor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Vendor by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the vendor", required = true, example = "1") @PathVariable("id") int idVendor) {
        return (vendorService.delete(idVendor)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
