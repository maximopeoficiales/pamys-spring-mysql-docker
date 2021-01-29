package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Order;

public interface IOrderRepository {
     List<Order> getAll();

     Optional<Order> getOrder(int idOrder);

     Optional<List<Order>> getIdClient(int idClient);

     // Optional<List<Order>> getStatus(int status);

     Optional<List<Order>> getDateCreated(String dateCreated);

     Order save(Order Order);

     void delete(int idOrder);
}
