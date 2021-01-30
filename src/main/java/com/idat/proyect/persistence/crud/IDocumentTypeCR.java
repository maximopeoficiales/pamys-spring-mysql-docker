package com.idat.proyect.persistence.crud;

import com.idat.proyect.persistence.entity.DocumentType;

import org.springframework.data.repository.CrudRepository;

public interface IDocumentTypeCR extends CrudRepository<DocumentType, Integer> {

}
