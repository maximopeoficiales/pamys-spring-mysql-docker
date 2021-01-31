package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.OrderRepository;
import com.idat.proyect.persistence.entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int idOrder) {
        return orderRepository.getOrder(idOrder);
    }

    public Order save(Order order) {

        order.setProducts(null);
        return orderRepository.save(order);
    }

    public boolean delete(int idOrder) {
        return getOrder(idOrder).map(Order -> {
            orderRepository.delete(idOrder);
            return true;
        }).orElse(false);
    }
}
