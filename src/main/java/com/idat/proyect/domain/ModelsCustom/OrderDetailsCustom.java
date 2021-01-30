package com.idat.proyect.domain.ModelsCustom;

import lombok.Data;

@Data
public class OrderDetailsCustom {
    private Integer idOrder;
    private Integer idProduct;
    private Double price;
    private Integer quantity;
}
