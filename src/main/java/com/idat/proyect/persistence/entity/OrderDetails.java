package com.idat.proyect.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {

     // @Id
     // @GeneratedValue(strategy = GenerationType.IDENTITY)
     // @Column(name = "id")
     // private Integer idOrderDetails;
     
     @EmbeddedId
     private OrderDetailsPK id;

     private Integer quantity;

     // Muchos ordenes detalle tiene una sola orden
     @ManyToOne
     @MapsId("idOrder")
     @JoinColumn(name = "idOrder", insertable = false, updatable = false)
     private Order order;
     
     // Muchos ordenes detalle tiene una sola orden
     @ManyToOne
     @JoinColumn(name = "idProduct", insertable = false, updatable = false)
     private Product product;
}
