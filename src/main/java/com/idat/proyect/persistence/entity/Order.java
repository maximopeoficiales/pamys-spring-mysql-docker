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
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idOrder;

     @Column(name = "id_client")
     private Integer idClient;

     private Double subtotal;
     private Double igv;
     private Double total;

     @Column(length = 100, name = "shipping_address")
     private String shippingAddress;

     @Column(length = 150, name = "comment")
     private String comment;

     @Column(name = "zip_code")
     private Integer zipCode;

     @Column(name = "id_document_type")
     private Integer idDocumentType;

     @Column(name = "id_order_status")
     private Integer idOrderStatus;

     @Column(name = "id_payment_status")
     private Integer idPaymentStatus;

     @Column(name = "id_voucher")
     private Integer idVoucher;

     @Column(name = "date_created")
     private LocalDateTime dateCreated;

     // RELACIONES DE LAS TABLAS

     // muchas compras pueden ser hechas por un solo cliente
     // @ManyToOne
     // @JoinColumn(name = "idClient", insertable = false, updatable = false)
     // private Client client;

     @ManyToOne
     @JoinColumn(name = "id_client", insertable = false, updatable = false)
     private Client client;

     @ManyToOne
     @JoinColumn(name = "id_document_type", insertable = false, updatable = false)
     private DocumentType documentType;

     @ManyToOne
     @JoinColumn(name = "id_order_status", insertable = false, updatable = false)
     private OrderStatus orderStatus;

     @ManyToOne
     @JoinColumn(name = "id_payment_status", insertable = false, updatable = false)
     private PaymentType paymentType;

     // todas compras tendran en cascada sus productos
     // dentro de la clase OrderDetails el campo product
     // esto se usara para guardar producto en cascada
     // mappedBy a Order porque este es el que tiene la relacion e internamente este
     // usara id_producto

     @OneToMany(mappedBy = "order", cascade = { CascadeType.ALL })
     private List<OrderDetails> products;

     @OneToOne(cascade = { CascadeType.ALL })
     @JoinColumn(name = "id_voucher", insertable = false, updatable = false)
     private Voucher voucher;
}
