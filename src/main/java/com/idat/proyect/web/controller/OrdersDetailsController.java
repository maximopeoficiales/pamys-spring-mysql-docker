package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.ModelsCustom.OrderDetailsCustom;
import com.idat.proyect.domain.service.OrderDetailsService;
import com.idat.proyect.persistence.entity.OrderDetails;
import com.idat.proyect.persistence.entity.OrderDetailsPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/order_details")
public class OrdersDetailsController {
    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket Orderdetails")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<OrderDetails>> getAll() {
        return new ResponseEntity<>(orderDetailsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a OrdersDetails with a IDOrder")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "OrderDetails not found") })
    public ResponseEntity<List<OrderDetails>> getById(
            @ApiParam(value = "The id of the OrdersDetails", required = true, example = "5") @PathVariable("id") int idOrder) {
        // si no existe un producto retorna un NOT_FOUND
        return orderDetailsService.getOrderDetailsByIdOrder(idOrder).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/deleteByIdOrder")
    @ApiOperation("Delete  OrdersDetails by IdOrder and IdProduct")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> deleteByIdOrderAndIdProduct(@RequestBody OrderDetailsPK orderDetailsPK) {
        // return? new ResponseEntity<>(HttpStatus.OK)
        // : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        orderDetailsService.deleteByIdOrderAndIdProduct(orderDetailsPK.getIdOrder(), orderDetailsPK.getIdProduct());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Save a OrdersDetails")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<OrderDetailsCustom> save(@RequestBody OrderDetailsCustom ordersDetailsCustom) {
        return new ResponseEntity<>(orderDetailsService.saveCustom(ordersDetailsCustom), HttpStatus.CREATED);
    }

    // @PutMapping
    // @ApiOperation("Update a OrdersDetails")
    // @ApiResponse(code = 201, message = "OK")
    // public ResponseEntity<OrdersDetails> update(@RequestBody OrdersDetails
    // ordersDetails) {
    // OrdersDetails currentOrder =
    // orderDetailsService.getOrder(ordersDetails.getIdOrder()).map(order -> {
    // return order;
    // }).orElse(null);
    // currentOrder.setIdClient(ordersDetails.getIdClient());
    // return new ResponseEntity<>(orderDetailsService.save(currentOrder),
    // HttpStatus.CREATED);
    // }

    // @DeleteMapping
    // @ApiOperation("Delete a Order by ID")
    // @ApiResponse(code = 201, message = "OK")
    // public ResponseEntity<?> delete(OrderDetails orderDetails) {
    // try {
    // orderDetailsService.delete(orderDetails);
    // return new ResponseEntity<>(HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // }
}
