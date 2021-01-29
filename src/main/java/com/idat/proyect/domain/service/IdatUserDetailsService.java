package com.idat.proyect.domain.service;

import java.util.ArrayList;

import com.idat.proyect.persistence.crud.IClientCR;
import com.idat.proyect.persistence.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//en esta clase le indica a spring que sobreescriba el metodo de registro de usuarios
@Service("userDetailsService")
public class IdatUserDetailsService implements UserDetailsService {
     // por ahora solo tiene un usuario en memoria
     @Autowired
     private IClientCR crud;

     @Override
     @Transactional(readOnly = true)
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

          // si encuentra un resultado devuelve el cliente si no null
          Client client = crud.findByUsername(username).map(Client -> {
               return Client;
          }).orElse(null);

          if (client == null) {
               throw new UsernameNotFoundException(username);
          }
          /* creo array de roles */
          var roles = new ArrayList<GrantedAuthority>();
          roles.add(new SimpleGrantedAuthority(client.getRole().getName()));

          // obligatoriamente los roles se tiene que llamar|
          return new User(client.getUsername(), "{bcrypt}" + client.getPassword(), roles);
     }
}
