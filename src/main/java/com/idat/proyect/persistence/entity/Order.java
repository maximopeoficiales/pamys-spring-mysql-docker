package com.idat.proyect.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idOrder;

     @Column(name = "idClient")
     private Integer idClient;

     private Double total;

     @Column(length = 100, name = "shipping_address")
     private String shippingAddress;

     @Column(name = "date_created")
     private LocalDateTime dateCreated;

     private Integer status;

     // muchas compras pueden ser hechas por un solo cliente
     @ManyToOne
     @JoinColumn(name = "idClient", insertable = false, updatable = false)
     private Client client;

     // todas compras tendran en cascada sus productos
     // dentro de la clase OrderDetails el campo order
     @OneToMany(mappedBy = "order", cascade = { CascadeType.ALL })
     private List<OrderDetails> productos;

}
