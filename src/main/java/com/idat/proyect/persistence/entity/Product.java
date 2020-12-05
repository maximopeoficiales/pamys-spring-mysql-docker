package com.idat.proyect.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
     @Id
     @Column(name = "id", length = 30)
     private Integer idProduct;

     @Column(name = "idCategory")
     private Integer idCategory;

     @Column(name = "idVendor")
     private Integer idVendor;

     @Column(length = 50)
     private String name;

     private Double price;

     @Column(name = "sale_price")
     private Double salePrice;

     @Column(length = 255)
     private String description;

     @Column(length = 100, name = "thumbnail_url")
     private String thumbnailUrl;

     @Column(name = "date_created")
     private LocalDateTime dateCreated;

     private Integer stock;
}
