package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IOrderStatusRepository;
import com.idat.proyect.persistence.crud.IOrderStatusCR;
import com.idat.proyect.persistence.entity.OrderStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderStatusRepository implements IOrderStatusRepository {
    @Autowired
    IOrderStatusCR crud;

    @Override
    public List<OrderStatus> getAll() {
        return (List<OrderStatus>) crud.findAll();
    }

    @Override
    public Optional<OrderStatus> getOrderStatus(int idOrderStatus) {
        return crud.findById(idOrderStatus);
    }

    @Override
    public OrderStatus save(OrderStatus OrderStatus) {
        return crud.save(OrderStatus);
    }

    @Override
    public void delete(int idOrderStatus) {
        crud.deleteById(idOrderStatus);
    }

}
