package com.idat.proyect.domain.dto;

import lombok.Data;
// clase de estructura de la autenticacion 
@Data
public class AuthenticationRequest {
     private String username;
     private String password;
}
