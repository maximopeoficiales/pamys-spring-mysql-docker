package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IPaymentTypeRepository;
import com.idat.proyect.persistence.crud.IPaymentTypeCR;
import com.idat.proyect.persistence.entity.PaymentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentTypeRepository implements IPaymentTypeRepository {
    @Autowired
    IPaymentTypeCR crud;

    @Override
    public List<PaymentType> getAll() {
        return (List<PaymentType>) crud.findAll();
    }

    @Override
    public Optional<PaymentType> getPaymentType(int idPaymentType) {
        return crud.findById(idPaymentType);
    }

    @Override
    public PaymentType save(PaymentType PaymentType) {
        return crud.save(PaymentType);
    }

    @Override
    public void delete(int idDocumentType) {
        crud.deleteById(idDocumentType);
    }

}
