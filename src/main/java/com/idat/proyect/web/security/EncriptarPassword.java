package com.idat.proyect.web.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
     public static void main(String[] args) {
          var password = "123";
          System.out.println("password: " + password);
          System.out.println("password: " + encriptarPassword(password));
     }

     public static String encriptarPassword(String password) {
          // encripta password
          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
          return encoder.encode(password);
     }
}
