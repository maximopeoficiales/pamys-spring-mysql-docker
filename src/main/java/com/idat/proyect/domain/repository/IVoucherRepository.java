package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Voucher;

public interface IVoucherRepository {
    List<Voucher> getAll();

    Optional<Voucher> getVoucher(int idVoucher);

    Optional<List<Voucher>> getVoucherByIdClient(int idClient);

    Voucher save(Voucher Voucher);

    void delete(int idVoucher);
}
