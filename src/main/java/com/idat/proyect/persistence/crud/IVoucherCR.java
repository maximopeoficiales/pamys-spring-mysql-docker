package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Voucher;

import org.springframework.data.repository.CrudRepository;

public interface IVoucherCR extends CrudRepository<Voucher, Integer> {
    Optional<List<Voucher>> findByIdClient(Integer idClient);
}
