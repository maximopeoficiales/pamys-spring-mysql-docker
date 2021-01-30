package com.idat.proyect.domain.repository;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.entity.DocumentType;

public interface IDocumentTypeRespository {
    List<DocumentType> getAll();

    Optional<DocumentType> getDocumentType(int idDocumentType);

    DocumentType save(DocumentType DocumentType);

    void delete(int idDocumentType);
}
