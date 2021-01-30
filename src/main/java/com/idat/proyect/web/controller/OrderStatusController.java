package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.OrderStatusService;
import com.idat.proyect.persistence.entity.OrderStatus;

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
@RequestMapping("/order_status")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket OrderStatus")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<OrderStatus>> getAll() {
        return new ResponseEntity<>(orderStatusService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a OrderStatus with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Product not found") })
    public ResponseEntity<OrderStatus> getById(
            @ApiParam(value = "The id of the OrderStatus", required = true, example = "5") @PathVariable("id") int idOrderStatus) {
        // si no existe un producto retorna un NOT_FOUND
        return orderStatusService.getOrderStatus(idOrderStatus).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a OrderStatus")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<OrderStatus> save(@RequestBody OrderStatus orderStatus) {
        return new ResponseEntity<>(orderStatusService.save(orderStatus), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Order")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<OrderStatus> update(@RequestBody OrderStatus orderStatus) {
        OrderStatus currentOrdersStatus = orderStatusService.getOrderStatus(orderStatus.getIdOrderStatus())
                .map(orderStatuss -> {
                    return orderStatuss;
                }).orElse(null);
        currentOrdersStatus.setStatus(orderStatus.getStatus());
        return new ResponseEntity<>(orderStatusService.save(currentOrdersStatus), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a OrderStatus by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the OrderStatus", required = true, example = "1") @PathVariable("id") int idOrderStatus) {
        return (orderStatusService.delete(idOrderStatus)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
