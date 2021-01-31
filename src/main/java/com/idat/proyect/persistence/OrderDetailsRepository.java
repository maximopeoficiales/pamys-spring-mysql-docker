package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.ModelsCustom.OrderDetailsCustom;
import com.idat.proyect.domain.repository.IOrderDetailsRepository;
import com.idat.proyect.persistence.crud.IOrderDetailsCR;
import com.idat.proyect.persistence.entity.OrderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailsRepository implements IOrderDetailsRepository {

    @Autowired
    IOrderDetailsCR crud;

    @Override
    public List<OrderDetails> getAll() {
        return (List<OrderDetails>) crud.findAll();
    }

    @Override
    public OrderDetails save(OrderDetails OrderDetails) {
        return crud.save(OrderDetails);
    }

    @Override
    public void delete(OrderDetails orderDetails) {
        crud.delete(orderDetails);
    }

    @Override
    public Optional<List<OrderDetails>> getOrderDetailsByIdOrder(int idOrder) {
        return crud.findByIdIdOrder(idOrder);
    }

    @Override
    public void deleteByIdOrderAndIdProduct(int idOrder, int idProduct) {
        crud.deleteOrderDetailsCustom(idOrder, idProduct);
    }

    @Override
    public void saveOrderDetailsCustom(OrderDetailsCustom orderDetailsCustom) {
        crud.saveOrderDetailsCustom(orderDetailsCustom.getIdOrder(), orderDetailsCustom.getIdProduct(),
                orderDetailsCustom.getPrice(), orderDetailsCustom.getQuantity());
    }

    @Override
    public void updateOrderDetailsCustom(OrderDetailsCustom orderDetailsCustom) {
        crud.updateOrderDetailsCustom(orderDetailsCustom.getIdOrder(), orderDetailsCustom.getIdProduct(),
                orderDetailsCustom.getPrice(), orderDetailsCustom.getQuantity());

    }

}
