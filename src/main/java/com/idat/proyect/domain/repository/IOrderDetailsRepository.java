package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.OrderDetails;

public interface IOrderDetailsRepository {
     List<OrderDetails> getAll();

     Optional<OrderDetails> getOrderDetails(int idOrderDetails);

     OrderDetails save(OrderDetails OrderDetails);

     void delete(int idOrderDetails);
}
