package com.idat.proyect.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    // @Autowired
    // private ProductService productService;

    // @GetMapping("/all")
    // @ApiOperation("Get all supermarket products")
    // @ApiResponse(code = 200, message = "OK")
    // public ResponseEntity<List<Product>> getAll() {
    //     return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    // }
}
