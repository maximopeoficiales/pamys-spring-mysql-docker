package com.idat.proyect.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.Vendor;

import org.springframework.data.repository.CrudRepository;

public interface IVendorCR extends CrudRepository<Vendor, Integer> {
     // @Query(value = "SELECT * FROM vendor u WHERE u.company LIKE '%1?%'", nativeQuery = true)
     Optional<List<Vendor>> findByCompanyLike(String company);
}
