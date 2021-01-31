package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.ModelsCustom.OrderDetailsCustom;
import com.idat.proyect.persistence.OrderDetailsRepository;
import com.idat.proyect.persistence.entity.OrderDetails;
import com.idat.proyect.persistence.entity.OrderDetailsPK;

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

    public boolean deleteByIdOrderAndIdProduct(OrderDetailsPK orderDetailsPK) {
        var orderDetails = getOrderDetailsByIdOrder(orderDetailsPK.getIdOrder()).map(od -> {
            return od;
        }).orElse(null);
        if (orderDetails != null) {
            orderDetailsRepository.deleteByIdOrderAndIdProduct(orderDetailsPK.getIdOrder(),
                    orderDetailsPK.getIdProduct());
            return true;
        }
        return false;

    }

    public boolean saveCustom(OrderDetailsCustom orderDetailsCustom) {
        try {
            // si hay error es un erro de producto duplicado
            orderDetailsRepository.saveOrderDetailsCustom(orderDetailsCustom);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCustom(OrderDetailsCustom orderDetailsCustom) {
        try {
            // si hay error es un erro de producto duplicado
            orderDetailsRepository.updateOrderDetailsCustom(orderDetailsCustom);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
