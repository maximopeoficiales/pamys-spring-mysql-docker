package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.ModelsCustom.OrderDetailsCustom;
import com.idat.proyect.persistence.entity.OrderDetails;

public interface IOrderDetailsRepository {
     List<OrderDetails> getAll();

     Optional<List<OrderDetails>> getOrderDetailsByIdOrder(int idOrder);

     OrderDetails save(OrderDetails OrderDetails);

     void delete(OrderDetails orderDetails);

     void deleteByIdOrderAndIdProduct(int idOrder, int idProduct);

     void saveOrderDetailsCustom(OrderDetailsCustom orderDetailsCustom);

     void updateOrderDetailsCustom(OrderDetailsCustom orderDetailsCustom);
}
