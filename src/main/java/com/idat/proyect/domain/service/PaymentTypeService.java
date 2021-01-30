package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.PaymentTypeRepository;
import com.idat.proyect.persistence.entity.PaymentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    public List<PaymentType> getAll() {
        return paymentTypeRepository.getAll();
    }

    public Optional<PaymentType> getPaymentType(int idPaymentType) {
        return paymentTypeRepository.getPaymentType(idPaymentType);
    }

    public PaymentType save(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    public boolean delete(int idPaymentType) {
        return getPaymentType(idPaymentType).map(PaymentType -> {
            paymentTypeRepository.delete(idPaymentType);
            return true;
        }).orElse(false);
    }
}
