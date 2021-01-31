package com.idat.proyect.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idClient;

     @Column(length = 30)
     private String username;

     @Column(length = 100,name = "_password")
     private String password;

     // @Column(name = "idRole")
     // private Integer idRole;

     @Column(name = "first_name", length = 45)
     private String firstName;

     @Column(name = "last_name", length = 45)
     private String lastName;

     @Column(length = 100)
     private String address;

     @Column(length = 9)
     private String phone;

     @Column(length = 45)
     private String email;

     private Integer zip_code;

     private Boolean active;

     // id_client en el campo que esta en en el entity role
     // @OneToMany
     // @JoinColumn(name = "id_client")
     @Column(name = "id_rol")
     private Integer idRol;

     @OneToOne(cascade = { CascadeType.ALL })
     @JoinColumn(name = "id_rol", insertable = false, updatable = false)
     private Role role;

     // un cliente tiene muchas ordenes mappgedby cliente esta en la clase ORDER
     // @OneToMany(mappedBy = "client")
     // private List<Order> orders;

     /* ciclo de vida de persistance */
     // @PrePersist
     // void prePersist() {
     // // antes de guardar se hara esto
     // password = EncriptarPassword.encriptarPassword(password);
     // }
}
