package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.DocumentTypeService;
import com.idat.proyect.persistence.entity.DocumentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/document_type")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket DocumentType")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<DocumentType>> getAll() {
        return new ResponseEntity<>(documentTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a DocumentType with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Product not found") })
    public ResponseEntity<DocumentType> getById(
            @ApiParam(value = "The id of the DocumentType", required = true, example = "5") @PathVariable("id") int idDocumentType) {
        // si no existe un producto retorna un NOT_FOUND
        return documentTypeService.getDocumentType(idDocumentType).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a DocumentType")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<DocumentType> save(@RequestBody DocumentType DocumentType) {
        return new ResponseEntity<>(documentTypeService.save(DocumentType), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a DocumentType")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<DocumentType> update(@RequestBody DocumentType DocumentType) {
        DocumentType currentDocumentType = documentTypeService.getDocumentType(DocumentType.getIdDocumentType())
                .map(documentType -> {
                    return documentType;
                }).orElse(null);
        currentDocumentType.setDoctype(DocumentType.getDoctype());
        return new ResponseEntity<>(documentTypeService.save(currentDocumentType), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a DocumentType by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the DocumentType", required = true, example = "1") @PathVariable("id") int idDocumentType) {
        return (documentTypeService.delete(idDocumentType)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
