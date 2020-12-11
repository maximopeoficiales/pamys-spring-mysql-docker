package com.idat.proyect.domain.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//en esta clase le indica a spring que sobreescriba el metodo de registro de usuarios
@Service
public class IdatUserDetailsService implements UserDetailsService {
     //por ahora solo tiene un usuario en memoria
     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          return new User("admin", "{noop}admin", new ArrayList<>());
     }
}
