package com.idat.proyect.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "categorys")
public class Category {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idCategory;

     @Column(length = 45)
     private String name;

     @Column(length = 45)
     private String description;

     private Boolean active;

     // // una categoria puede tener muchos productos
     // @OneToMany(mappedBy = "category")
     // private List<Product> products;

}
