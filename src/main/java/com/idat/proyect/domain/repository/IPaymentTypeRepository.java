package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.PaymentType;

public interface IPaymentTypeRepository {
    List<PaymentType> getAll();

    Optional<PaymentType> getPaymentType(int idPaymentType);

    PaymentType save(PaymentType PaymentType);

    void delete(int idDocumentType);
}
