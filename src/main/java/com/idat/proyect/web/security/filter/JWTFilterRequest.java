package com.idat.proyect.web.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idat.proyect.domain.service.IdatUserDetailsService;
import com.idat.proyect.web.security.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTFilterRequest extends OncePerRequestFilter {

     // autoinstanciado
     @Autowired
     private JWTUtil jwtUtil; // necesaria para las funciones del token

     @Autowired
     private IdatUserDetailsService idatUserDetailsService; // informacion el usuario al tratar de ingresar

     // se sobreescribira un filtro interno para usar nuestra autenticacion JWT
     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
               throws ServletException, IOException {
          // request -> informacion del cliente al servidor
          // response -> respuesta del servidor

          // verificacion si viene un header con el token correcto
          String authorizationHeader = request.getHeader("Authorization");
          if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
               // ejemplo de header Authorization:
               // Bearer eyJhbGciOiJIUzI1NiJ9 ....

               // palabra Bearer mas espacio en blanco suma 7 caracteres
               String jwt = authorizationHeader.substring(7);

               String username = jwtUtil.extractUsername(jwt);

               // verifica que el usuario no esta logueado
               if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // verifica si esta regitrado en la bd
                    UserDetails userDetails = idatUserDetailsService.loadUserByUsername(username);

                    // devuelte true si el token es correcto
                    if (jwtUtil.validateToken(jwt, userDetails)) {
                         // se crea la autenticacion
                         UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                   userDetails, null, userDetails.getAuthorities());

                         // se guarda los detalles de la autenticacion
                         //como datos de navegador etc
                         authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                         
                         // asignar la autenticacion para que ya este logueado y no pase por este filtro
                         SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
               }
          }
          // el filtro sera evaluado
          filterChain.doFilter(request, response);
     }

}
