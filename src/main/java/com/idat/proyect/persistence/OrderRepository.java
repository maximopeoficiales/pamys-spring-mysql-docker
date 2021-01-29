package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IOrderRepository;
import com.idat.proyect.persistence.crud.IOrderCR;
import com.idat.proyect.persistence.entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository implements IOrderRepository {

     @Autowired
     private IOrderCR crud;

     @Override
     public List<Order> getAll() {
          return (List<Order>) crud.findAll();
     }

     @Override
     public Optional<Order> getOrder(int idOrder) {
          return crud.findById(idOrder);
     }

     @Override
     public Optional<List<Order>> getIdClient(int idClient) {
          return crud.findByIdClient(idClient);
     }

     // @Override
     // public Optional<List<Order>> getStatus(int status) {
     //      return crud.findByStatus(status);
     // }

     @Override
     public Optional<List<Order>> getDateCreated(String dateCreated) {
          return crud.findByDateCreated(dateCreated);
     }

     @Override
     public Order save(Order Order) {
          return crud.save(Order);
     }

     @Override
     public void delete(int idOrder) {
          crud.deleteById(idOrder);
     }

}
