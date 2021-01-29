package com.idat.proyect.persistence.entity;

import javax.persistence.Entity;

import javax.persistence.Table;
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

     private Double price;
     private Integer quantity;

     // la anotacion join colum con su propiedad name es el nombre de atributo con el
     // que esta declarado para la base de datos

     @ManyToOne
     @MapsId("id_order")
     @JoinColumn(name = "id_order", insertable = false, updatable = false)
     private Order order;

     // Muchos ordenes detalle tiene una sola orden
     @ManyToOne
     @JoinColumn(name = "id_product", insertable = false, updatable = false)
     private Product product;
}
