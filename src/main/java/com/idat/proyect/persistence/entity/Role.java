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
@Table(name = "roles")
public class Role {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idRole;

     @Column(length = 15)
     private String name;

     // cada usuario tendra un rol
     // @Column(name = "id_client")
     // private Integer idClient;
     // una categoria puede tener muchos productos
     // @OneToMany(mappedBy = "role")
     // private List<Client> clients;

}
