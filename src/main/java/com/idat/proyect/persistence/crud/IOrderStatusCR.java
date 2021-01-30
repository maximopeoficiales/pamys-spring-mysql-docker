package com.idat.proyect.persistence.crud;

import com.idat.proyect.persistence.entity.OrderStatus;

import org.springframework.data.repository.CrudRepository;

public interface IOrderStatusCR extends CrudRepository<OrderStatus, Integer> {

}
