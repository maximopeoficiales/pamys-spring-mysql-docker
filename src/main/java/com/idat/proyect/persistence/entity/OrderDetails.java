package com.idat.proyect.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idOrderDetails;

     private Integer idOrder;
     private Integer idProduct;

     private Integer quantity;

}
