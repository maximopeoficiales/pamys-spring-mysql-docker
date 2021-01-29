package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.VendorRepository;
import com.idat.proyect.persistence.entity.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAll() {
        return vendorRepository.getAll();
    }

    public Optional<Vendor> getVendor(int idVendor) {
        return vendorRepository.getVendor(idVendor);
    }

    public Optional<List<Vendor>> getByCompany(String company) {
        return vendorRepository.findByCompany(company);
    }

    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public boolean delete(int idVendor) {
        return getVendor(idVendor).map(vendor -> {
            vendorRepository.delete(idVendor);
            return true;
        }).orElse(false);
    }
}
