package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.ModelsCustom.OrderDetailsCustom;
import com.idat.proyect.persistence.OrderDetailsRepository;
import com.idat.proyect.persistence.entity.OrderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> getAll() {
        return orderDetailsRepository.getAll();
    }

    public Optional<List<OrderDetails>> getOrderDetailsByIdOrder(int idOrder) {
        return orderDetailsRepository.getOrderDetailsByIdOrder(idOrder);
    }

    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public boolean deleteByIdOrderAndIdProduct(int idOrder, int idProduct) {
        var orderDetails = getOrderDetailsByIdOrder(idOrder).map(od -> {
            return od;
        }).orElse(null);
        if (orderDetails != null) {
            orderDetailsRepository.deleteByIdOrderAndIdProduct(idOrder, idProduct);
            return true;
        }
        return false;

    }

    public OrderDetailsCustom saveCustom(OrderDetailsCustom orderDetailsCustom) {
        return orderDetailsRepository.saveOrderDetailsCustom(orderDetailsCustom);
    }

}
