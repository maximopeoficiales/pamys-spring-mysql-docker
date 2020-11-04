package com.idat.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.idat.demo.modelo.Persona;

public interface IPersona extends CrudRepository<Persona, Integer>{

}
