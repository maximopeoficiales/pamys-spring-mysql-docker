package com.idat.proyect.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {

     @EmbeddedId
     private OrderDetailsPK id;

     private Integer quantity;

     // Muchos ordenes detalle tiene una sola orden
     @ManyToOne
     @MapsId("idOrder")
     @JoinColumn(name = "id", insertable = false, updatable = false)
     private Order order;
     
     // Muchos ordenes detalle tiene una sola orden
     @ManyToOne
     @JoinColumn(name = "id", insertable = false, updatable = false)
     private Product product;
}
