package com.idat.proyect.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//estructura de respuesta de la authenticacion
@Data
@AllArgsConstructor
public class AuthenticationResponse {
     private String jwt;


}
