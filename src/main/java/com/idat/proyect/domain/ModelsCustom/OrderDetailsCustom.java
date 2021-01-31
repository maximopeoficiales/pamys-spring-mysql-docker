package com.idat.proyect.domain.ModelsCustom;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderDetailsCustom {
    private Integer idOrder;
    private Integer idProduct;
    private Double price;
    private Integer quantity;
}
