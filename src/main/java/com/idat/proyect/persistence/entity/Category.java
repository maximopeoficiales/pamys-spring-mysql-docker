package com.idat.proyect.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idCategory;

     @Column(length = 45)
     private String name;

     @Column(length = 45)
     private String description;

     private Integer active;

     // una categoria puede tener muchos productos
     @OneToMany(mappedBy = "category")
     private List<Product> products;

     
}
