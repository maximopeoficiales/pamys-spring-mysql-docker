package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.PaymentTypeService;
import com.idat.proyect.persistence.entity.PaymentType;

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
@RequestMapping("/payment_type")
public class PaymentTypeController {
    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket paymenttype")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<PaymentType>> getAll() {
        return new ResponseEntity<>(paymentTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a paymenttype with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Payment not found") })
    public ResponseEntity<PaymentType> getById(
            @ApiParam(value = "The id of the paymenttype", required = true, example = "5") @PathVariable("id") int idPaymentType) {
        // si no existe un producto retorna un NOT_FOUND
        return paymentTypeService.getPaymentType(idPaymentType).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a PaymentType")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<PaymentType> save(@RequestBody PaymentType paymenttype) {
        return new ResponseEntity<>(paymentTypeService.save(paymenttype), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a PaymentType")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<PaymentType> update(@RequestBody PaymentType paymenttype) {

        PaymentType currentClient = paymentTypeService.getPaymentType(paymenttype.getIdPaymentType())
                .map(PaymentType -> {
                    return PaymentType;
                }).orElse(null);
        currentClient.setType(paymenttype.getType());
        return new ResponseEntity<>(paymentTypeService.save(currentClient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a PaymentType by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the paymenttype", required = true, example = "1") @PathVariable("id") int idPaymentType) {
        return (paymentTypeService.delete(idPaymentType)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
