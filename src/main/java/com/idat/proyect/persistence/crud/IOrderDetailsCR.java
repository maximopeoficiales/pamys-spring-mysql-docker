package com.idat.proyect.persistence.crud;

import com.idat.proyect.persistence.entity.OrderDetails;

import org.springframework.data.repository.CrudRepository;

public interface IOrderDetailsCR extends CrudRepository<OrderDetails, Integer> {

}
