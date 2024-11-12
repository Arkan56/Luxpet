package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Admin;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Role;
import com.example.demo.entidades.UserEntity;
import com.example.demo.entidades.Veterinario;
import com.example.demo.repositorio.RoleRepository;
import com.example.demo.repositorio.UserRepository;



@Service
public class CustomUserDetailService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username)
        );

        UserDetails userDetails = new User(userDB.getUsername(), userDB.getPassword(), mapToGrantedAuthoritys(userDB.getRoles()));
        
        return userDetails;
    }

    private Collection<GrantedAuthority> mapToGrantedAuthoritys(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity ClienteToUser(Cliente cliente) {
        UserEntity user = new UserEntity();
        user.setUsername(String.valueOf(cliente.getCedula()));
        user.setPassword(passwordEncoder.encode(cliente.getContrasenia()));
        
        Role roles = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity VeterinarioToUser(Veterinario veterinario) {
        UserEntity user = new UserEntity();
        user.setUsername(String.valueOf(veterinario.getCedula()));
        user.setPassword(passwordEncoder.encode(veterinario.getContrasenia()));
        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity AdministradorToUser(Admin administrador) {
        UserEntity user = new UserEntity();
        user.setUsername(String.valueOf(administrador.getCedula()));
        user.setPassword(passwordEncoder.encode(administrador.getContrasenia()));
        Role roles = roleRepository.findByName("ADMIN").get();
        user.setRoles(List.of(roles));
        return user;
    }
}