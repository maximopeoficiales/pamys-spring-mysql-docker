package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.OrderDetails;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IOrderDetailsCR extends CrudRepository<OrderDetails, Integer> {

    Optional<List<OrderDetails>> findByIdIdOrder(Integer IdIdOrder);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM order_details  WHERE id_order=?1 AND id_product=?2", nativeQuery = true)
    void deleteOrderDetailsCustom(int idOrder, int idProduct);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO order_details (id_order,id_product,price,quantity) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    void saveOrderDetailsCustom(int idOrder, int idProduct, double price, int quantity);

    @Transactional
    @Modifying
    @Query(value = "UPDATE order_details SET price = ?3 , quantity= ?4  WHERE id_order= ?1 AND id_product= ?2", nativeQuery = true)
    void updateOrderDetailsCustom(int idOrder, int idProduct, double price, int quantity);
}
