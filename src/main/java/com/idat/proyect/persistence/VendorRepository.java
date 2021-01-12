package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IVendorRepository;
import com.idat.proyect.persistence.crud.IVendorCR;
import com.idat.proyect.persistence.entity.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VendorRepository implements IVendorRepository {

    @Autowired
    private IVendorCR crud;

    @Override
    public List<Vendor> getAll() {
        return (List<Vendor>) crud.findAll();
    }

    @Override
    public Optional<Vendor> getVendor(int idVendor) {
        return crud.findById(idVendor);
    }

    @Override
    public Optional<List<Vendor>> findByCompany(String company) {
        return crud.findByCompanyLike("%" + company + "%");
    }

    @Override
    public Vendor save(Vendor vendor) {
        return crud.save(vendor);
    }

    @Override
    public void delete(int idVendor) {
        crud.deleteById(idVendor);
    }

}
