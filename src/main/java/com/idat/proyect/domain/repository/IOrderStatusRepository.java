package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.OrderStatus;

public interface IOrderStatusRepository {
    List<OrderStatus> getAll();

    Optional<OrderStatus> getOrderStatus(int idOrderStatus);

    OrderStatus save(OrderStatus OrderStatus);

    void delete(int idOrderStatus);
}
