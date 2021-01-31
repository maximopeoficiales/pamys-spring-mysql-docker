package com.idat.proyect.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "product_images")
public class ProductImages {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idProductImages;

     @Column(name = "id_product")
     private Integer idProduct;
     
     @Column(length = 300)
     private String url;

     @ManyToOne
     @JoinColumn(name = "id_product", insertable = false, updatable = false)
     @JsonIgnore // evita la multidependencia
     Product product;
}
