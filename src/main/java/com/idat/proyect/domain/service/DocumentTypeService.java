package com.idat.proyect.domain.service;

import java.util.List;
import java.util.Optional;

import com.idat.proyect.persistence.DocumentTypeRepository;
import com.idat.proyect.persistence.entity.DocumentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeService {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public List<DocumentType> getAll() {
        return documentTypeRepository.getAll();
    }

    public Optional<DocumentType> getDocumentType(int idDocumentType) {
        return documentTypeRepository.getDocumentType(idDocumentType);
    }

    public DocumentType save(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    public boolean delete(int idDocumentType) {
        return getDocumentType(idDocumentType).map(DocumentType -> {
            documentTypeRepository.delete(idDocumentType);
            return true;
        }).orElse(false);
    }
}
