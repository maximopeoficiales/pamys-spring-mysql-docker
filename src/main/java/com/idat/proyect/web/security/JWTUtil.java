package com.idat.proyect.web.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
     // key necesaria para la encriptacion
     private static final String KEY = "1d4tpr0y3ct";

     public String generaToken(UserDetails userDetails) {
          /*
           * subject : es el usuario issuedat: dia de creacion expiration: dia de
           * expiracion ejem: 10 horas logueo con algoritmo de encriptacion y la key
           * compact: convierte en string
           */
          Integer hours = 10; // 10 horas de validez
          return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * hours))
                    .signWith(SignatureAlgorithm.HS256, KEY).compact();
     }

     public boolean validateToken(String token, UserDetails userDetails) {
          // verifica si el username es correcto y no ha caducado
          return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
     }

     public String extractUsername(String token) {
          // obtiene usuario del jwt
          return getClaims(token).getSubject();
     }

     public boolean isTokenExpired(String token) {
          // verifica si la fecha de expiracion es antes del dia
          return getClaims(token).getExpiration().before(new Date());
     }

     public Claims getClaims(String token) {
          // obtiene los datos del jwt
          return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
     }

}