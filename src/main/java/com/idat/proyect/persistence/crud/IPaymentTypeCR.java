package com.idat.proyect.persistence.crud;

import com.idat.proyect.persistence.entity.PaymentType;

import org.springframework.data.repository.CrudRepository;

public interface IPaymentTypeCR extends CrudRepository<PaymentType,Integer> {
    
}
