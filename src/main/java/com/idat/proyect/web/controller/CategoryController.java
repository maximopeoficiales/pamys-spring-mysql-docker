package com.idat.proyect.web.controller;

import java.util.List;

import com.idat.proyect.domain.service.CategoryService;
import com.idat.proyect.persistence.entity.Category;

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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket category")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a category with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Product not found") })
    public ResponseEntity<Category> getById(
            @ApiParam(value = "The id of the category", required = true, example = "5") @PathVariable("id") int idCategory) {
        // si no existe un producto retorna un NOT_FOUND
        return categoryService.getCategory(idCategory).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Category")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Category")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Category> update(@RequestBody Category category) {

        Category currentClient = categoryService.getCategory(category.getIdCategory()).map(Category -> {
            return Category;
        }).orElse(null);
        currentClient.setName(category.getName());
        currentClient.setDescription(category.getDescription());
        currentClient.setActive(category.getActive());
        return new ResponseEntity<>(categoryService.save(currentClient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Category by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the category", required = true, example = "1") @PathVariable("id") int idCategory) {
        return (categoryService.delete(idCategory)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
