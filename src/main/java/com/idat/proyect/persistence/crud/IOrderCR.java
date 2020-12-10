package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Order;

import org.springframework.data.repository.CrudRepository;

public interface IOrderCR extends CrudRepository<Order, Integer> {
     // Optional<List<Order>> findByIdCliente(Integer idCliente);

     Optional<List<Order>> findByStatus(Integer status);

     // "SELECT * FROM wp_cotizaciones WHERE customer_id = $user_id AND DATE_FORMAT(date_created,'%Y-%m-%d') = '$fcre' AND cod=$cod";
     // @Query("SELECT * FROM Order WHERE DATE_FORMAT(date_created) = ?1")
     Optional<List<Order>> findByDateCreated(String dateCreated);
}
