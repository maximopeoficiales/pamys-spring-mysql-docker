package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Vendor;

public interface IVendorRepository {
     List<Vendor> getAll();

     Optional<Vendor> getVendor(int idVendor);

     Vendor save(Vendor Vendor);

     void delete(int idVendor);
}
