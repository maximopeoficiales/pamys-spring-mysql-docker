package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IOrderCR extends CrudRepository<Order, Integer> {
     Optional<List<Order>> findByIdClient(Integer idClient);

     // Optional<List<Order>> findByStatus(Integer status);

     @Query(value = "SELECT * FROM orders u WHERE DATE_FORMAT(u.date_created) = ?1", nativeQuery = true)
     Optional<List<Order>> findByDateCreated(String dateCreated);
}
