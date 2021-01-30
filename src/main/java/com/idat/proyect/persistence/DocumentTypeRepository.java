package com.idat.proyect.persistence;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.domain.repository.IDocumentTypeRespository;
import com.idat.proyect.persistence.crud.IDocumentTypeCR;
import com.idat.proyect.persistence.entity.DocumentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentTypeRepository implements IDocumentTypeRespository {
    @Autowired
    private IDocumentTypeCR crud;

    @Override
    public List<DocumentType> getAll() {
        return (List<DocumentType>) crud.findAll();
    }

    @Override
    public Optional<DocumentType> getDocumentType(int idDocumentType) {
        return crud.findById(idDocumentType);
    }

    @Override
    public DocumentType save(DocumentType DocumentType) {
        return crud.save(DocumentType);
    }

    @Override
    public void delete(int idDocumentType) {
        crud.deleteById(idDocumentType);
    }

}
