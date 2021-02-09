package com.idat.proyect.web.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.idat.proyect.domain.service.ClientService;
import com.idat.proyect.domain.service.ProductService;
import com.idat.proyect.persistence.entity.Client;
import com.idat.proyect.persistence.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// @CrossOrigin(origins="*")
@RestController
@RequestMapping("/public")
public class PublicController {
    @Value("${myConfig.pathVouchers}")
    String nameDirectoryVouchers;

    @Value("${myConfig.pathImagesClients}")
    String nameDirectoryPhotos;

    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    // @Autowired
    // private VoucherService voucherService;

    @PostMapping("/client")
    @ApiOperation("Save a Client")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @GetMapping("/product")
    @ApiOperation("Get all products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/product/slug/{slug}")
    @ApiOperation("Search a product with a slug")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Product not found") })
    public ResponseEntity<Product> getProductBySlug(
            @ApiParam(value = "The slug of the product", required = true, example = "product-slug-example") @PathVariable("slug") String slug) {
        // si no existe un producto retorna un NOT_FOUND
        return productService.getBySlug(slug).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // obtener imagen del cliente
    @GetMapping("/clients/photos/{nombreFoto:.+}")
    public ResponseEntity<Resource> showPhotoClient(@PathVariable String nombreFoto) {
        Path rutaArchivo = Paths.get(this.nameDirectoryPhotos).resolve(nombreFoto).toAbsolutePath();
        // log.info(rutaArchivo.toString());
        Resource recurso = null;
        try {
            recurso = new UrlResource(rutaArchivo.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (!recurso.exists() && !recurso.isReadable()) {
            throw new RuntimeException("Error no se puedo cargar la imagen " + nombreFoto);
        }
        HttpHeaders cabecera = new HttpHeaders();
        // esta linea hace que descargue el archivo
        // cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
        // recurso.getFilename() + "\"");
        cabecera.add(HttpHeaders.CONTENT_TYPE, "image/png");
        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }

    // obtener imagen del cliente
    @GetMapping("/vouchers/photos/{nombreFoto:.+}")
    public ResponseEntity<Resource> showPhotoVoucher(@PathVariable String nombreFoto) {
        Path rutaArchivo = Paths.get(this.nameDirectoryVouchers).resolve(nombreFoto).toAbsolutePath();
        // log.info(rutaArchivo.toString());
        Resource recurso = null;
        try {
            recurso = new UrlResource(rutaArchivo.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (!recurso.exists() && !recurso.isReadable()) {
            throw new RuntimeException("Error no se puedo cargar la imagen " + nombreFoto);
        }
        HttpHeaders cabecera = new HttpHeaders();
        // esta linea hace que descargue el archivo
        // cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
        // recurso.getFilename() + "\"");
        cabecera.add(HttpHeaders.CONTENT_TYPE, "image/png");
        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }

}
