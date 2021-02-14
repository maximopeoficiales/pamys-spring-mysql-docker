package com.idat.proyect.web.controller;

import java.io.IOException;

import java.util.List;

import com.idat.proyect.domain.service.VoucherService;
import com.idat.proyect.environments.Enviroments;
import com.idat.proyect.persistence.entity.Voucher;
import com.idat.proyect.web.utilities.PhotoOperations;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/voucher")
public class VoucherController {
    @Autowired
    private PhotoOperations photoOperationsService;

    @Autowired
    private Enviroments env;

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket voucher")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Voucher>> getAll() {
        return new ResponseEntity<>(voucherService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idVoucher}")
    @ApiOperation("Search a voucher with a ID")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Payment not found") })
    public ResponseEntity<Voucher> getById(
            @ApiParam(value = "The id of the voucher", required = true, example = "5") @PathVariable("idVoucher") int idVoucher) {
        // si no existe un producto retorna un NOT_FOUND
        return voucherService.getVoucher(idVoucher).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id_client}")
    @ApiOperation("Search a voucher with a idClient")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Voucher not found") })
    public ResponseEntity<List<Voucher>> getByIdClient(
            @ApiParam(value = "The id of the voucher", required = true, example = "5") @PathVariable("id_client") int id_client) {
        // si no existe un producto retorna un NOT_FOUND
        return voucherService.getVoucherByIdClient(id_client).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Voucher")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Voucher> save(@RequestBody Voucher voucher) {
        return new ResponseEntity<>(voucherService.save(voucher), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Voucher")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Voucher> update(@RequestBody Voucher voucher) {

        Voucher currentClient = voucherService.getVoucher(voucher.getIdVoucher()).map(Voucher -> {
            return Voucher;
        }).orElse(null);
        currentClient.setImageUrl(voucher.getImageUrl());
        currentClient.setIdClient(voucher.getIdClient());
        currentClient.setPaymentDate(voucher.getPaymentDate());
        currentClient.setIdOperation(voucher.getIdOperation());
        currentClient.setIdClientAccount(voucher.getIdClientAccount());
        currentClient.setIdStoreAccount(voucher.getIdStoreAccount());
        currentClient.setAmount(voucher.getAmount());
        return new ResponseEntity<>(voucherService.save(currentClient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idVoucher}")
    @ApiOperation("Delete a Voucher by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the voucher", required = true, example = "1") @PathVariable("idVoucher") int idVoucher) {
        return (voucherService.delete(idVoucher)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // subir imagen
    @PostMapping("/photos/upload")
    public ResponseEntity<Voucher> uploadPhotoVoucher(@RequestParam("imgFile") MultipartFile file,
            @RequestParam("idVoucher") Integer idVoucher) {

        Voucher voucher = voucherService.getVoucher(idVoucher).map(voucherone -> voucherone).orElse(null);
        // si el archivo no esta vacio y si existe un voucher
        if (!file.isEmpty() && voucher != null) {
            String fileName = null;
            try {
                fileName = this.photoOperationsService.copyPhoto(file, this.env.nameDirectoryVouchersPhotos);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            // antes de guardar eliminamos la foto existente
            this.photoOperationsService.removePhoto(voucher.getImageUrl(), this.env.nameDirectoryVouchersPhotos);
            // guardo nueva foto
            voucher.setImageUrl(fileName);
            var voucherUpdated = voucherService.save(voucher);
            return new ResponseEntity<Voucher>(voucherUpdated, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
