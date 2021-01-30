package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.VoucherRepository;
import com.idat.proyect.persistence.entity.Voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public List<Voucher> getAll() {
        return voucherRepository.getAll();
    }

    public Optional<Voucher> getVoucher(int idVoucher) {
        return voucherRepository.getVoucher(idVoucher);
    }

    public Optional<List<Voucher>> getVoucherByIdClient(int idClient) {
        return voucherRepository.getVoucherByIdClient(idClient);
    }

    public Voucher save(Voucher Voucher) {
        return voucherRepository.save(Voucher);
    }

    public boolean delete(int idVoucher) {
        return getVoucher(idVoucher).map(Voucher -> {
            voucherRepository.delete(idVoucher);
            return true;
        }).orElse(false);
    }
}
