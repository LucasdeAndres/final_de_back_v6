package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.User;
import com.example.clinica_v6.entidades.UserDTO;
import com.example.clinica_v6.entidades.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

public interface
UserServiceInterface {
    User crearUser(UserDTO userDTO);
    UserDTO searchUser(Long id);
    void updateUser(UserDTO userDTO);
    void remove(Long id);
    Set<UserDTO> getTodos();
    UserDetails loadUserByUsername (String username) throws UsernameNotFoundException;
}
