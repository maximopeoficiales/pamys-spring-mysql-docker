package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.OrderStatusRepository;
import com.idat.proyect.persistence.entity.OrderStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public List<OrderStatus> getAll() {
        return orderStatusRepository.getAll();
    }

    public Optional<OrderStatus> getOrderStatus(int idOrderStatus) {
        return orderStatusRepository.getOrderStatus(idOrderStatus);
    }

    public OrderStatus save(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    public boolean delete(int idOrderStatus) {
        return getOrderStatus(idOrderStatus).map(OrderStatus -> {
            orderStatusRepository.delete(idOrderStatus);
            return true;
        }).orElse(false);
    }
}
