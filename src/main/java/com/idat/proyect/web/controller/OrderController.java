package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.OrderService;
import com.idat.proyect.persistence.entity.Order;

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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket Order")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a Order with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Product not found") })
    public ResponseEntity<Order> getById(
            @ApiParam(value = "The id of the Order", required = true, example = "5") @PathVariable("id") int idOrder) {
        // si no existe un producto retorna un NOT_FOUND
        return orderService.getOrder(idOrder).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Order")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Order> save(@RequestBody Order Order) {
        return new ResponseEntity<>(orderService.save(Order), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Order")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Order> update(@RequestBody Order Order) {
        Order currentOrder = orderService.getOrder(Order.getIdOrder()).map(order -> {
            return order;
        }).orElse(null);
        currentOrder.setIdClient(Order.getIdClient());
        currentOrder.setSubtotal(Order.getSubtotal());
        currentOrder.setIgv(Order.getIgv());
        currentOrder.setTotal(Order.getTotal());
        currentOrder.setComment(Order.getComment());
        currentOrder.setShippingAddress(Order.getShippingAddress());
        currentOrder.setZipCode(Order.getZipCode());
        currentOrder.setIdDocumentType(Order.getIdDocumentType());
        currentOrder.setIdOrderStatus(Order.getIdOrderStatus());
        currentOrder.setIdPaymentStatus(Order.getIdPaymentStatus());
        currentOrder.setIdVoucher(Order.getIdVoucher());
        // currentOrder.setProducts(Order.getProducts());
        return new ResponseEntity<>(orderService.save(currentOrder), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Order by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the Order", required = true, example = "1") @PathVariable("id") int idOrder) {
        return (orderService.delete(idOrder)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
