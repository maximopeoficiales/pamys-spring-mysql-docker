package com.idat.proyect.web.controller;

import com.idat.proyect.domain.dto.AuthenticationRequest;
import com.idat.proyect.domain.dto.AuthenticationResponse;
import com.idat.proyect.domain.service.ClientService;
import com.idat.proyect.domain.service.IdatUserDetailsService;
import com.idat.proyect.persistence.entity.Client;
import com.idat.proyect.web.security.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
// @CrossOrigin(origins="*")
public class AuthController {
     // clase de spring security para saber si estas autenticado
     @Autowired
     private AuthenticationManager authenticationManager;

     // este servicio busca los usuarios registrados sea en memoria o en la bd
     @Autowired
     private IdatUserDetailsService idatUserDetailsService;

     // componente creado para generarnew AuthenticationResponse(jwt), un jwt
     @Autowired
     private JWTUtil jwtUtil;

     // Servicio de Clientes
     @Autowired
     private ClientService clientService;

     // usamos nuestra clases dto AuthenticationResponse AuthenticationRequest

     @PostMapping("/authenticate")
     public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
          try {
               // se autentica con spring
               authenticationManager.authenticate(
                         new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
               // busco al usuario si esta registrado
               UserDetails userDetails = idatUserDetailsService.loadUserByUsername(request.getUsername());

               // genero un jwt
               String jwt = jwtUtil.generaToken(userDetails);

               // getUser for name
               Client client = clientService.getUsername(jwtUtil.extractUsername(jwt)).map(Client -> {
                    return Client;
               }).orElse(null);

               // retorno el jwt si todo sale correcto
               return new ResponseEntity<>(new AuthenticationResponse(jwt, client), HttpStatus.OK);

          } catch (BadCredentialsException e) {
               // si ocurre una exception de tipo badcredentials retorna un not found
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
     }
}
