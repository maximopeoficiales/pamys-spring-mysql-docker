package com.idat.proyect.persistence.crud;

import com.idat.proyect.persistence.entity.Vendor;

import org.springframework.data.repository.CrudRepository;

public interface IVendorCR extends CrudRepository<Vendor, Integer> {

}
