package com.idat.proyect.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vendors")
public class Vendor {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idVendor;
     @Column(length = 40)
     private String company;
     @Column(length = 100)
     private String description;

     //un proveedor puede tener muchos productos
     // @OneToMany(mappedBy = "vendor")
     // private List<Product> products;
}
