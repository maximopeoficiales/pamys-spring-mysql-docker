package com.idat.proyect.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vouchers")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idVoucher;

    @Column(name = "image_url",length = 300)
    private String imageUrl;

    @Column(name = "id_client")
    private Integer idClient;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "id_operation")
    private Integer idOperation;

    @Column(name = "id_client_account")
    private Integer idClientAccount;

    @Column(name = "id_store_account")
    private Integer idStoreAccount;

    private Double amount;

    @JsonIgnore
    @OneToOne(mappedBy = "voucher")
    private Order order;
}
