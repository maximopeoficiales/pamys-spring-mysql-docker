package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IVoucherRepository;
import com.idat.proyect.persistence.crud.IVoucherCR;
import com.idat.proyect.persistence.entity.Voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VoucherRepository implements IVoucherRepository {
    @Autowired
    IVoucherCR crud;

    @Override
    public List<Voucher> getAll() {
        return (List<Voucher>) crud.findAll();
    }

    @Override
    public Optional<Voucher> getVoucher(int idVoucher) {
        return crud.findById(idVoucher);
    }

    @Override
    public Optional<List<Voucher>> getVoucherByIdClient(int idClient) {
        return crud.findByIdClient(idClient);
    }

    @Override
    public Voucher save(Voucher Voucher) {
        return crud.save(Voucher);
    }

    @Override
    public void delete(int idVoucher) {
        crud.deleteById(idVoucher);
    }

}
