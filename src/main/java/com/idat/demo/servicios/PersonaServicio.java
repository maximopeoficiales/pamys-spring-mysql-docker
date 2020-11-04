package com.idat.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.demo.interfaces.IPersona;
import com.idat.demo.interfazServicio.IpersonaServicio;
import com.idat.demo.modelo.Persona;

@Service
public class PersonaServicio implements IpersonaServicio {

	@Autowired
	IPersona data;

	@Override
	public List<Persona> listar() {
		return (List<Persona>) data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int d) {
		return data.findById(d);
	}

	@Override
	public void save(Persona p) {
		// int res=0;
		data.save(p);
		// if(!persona.equals(null)) {
		// res=1;
		// }
		// return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
