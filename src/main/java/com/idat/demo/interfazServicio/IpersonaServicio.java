package com.idat.demo.interfazServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.idat.demo.modelo.Persona;

@Repository
public interface IpersonaServicio {
	
	public List<Persona>listar();
	public Optional<Persona>listarId(int d);
	public void save(Persona p);
	public void delete(int id);

}
