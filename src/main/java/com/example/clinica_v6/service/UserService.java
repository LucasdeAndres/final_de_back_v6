package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.User;
import com.example.clinica_v6.entidades.UserDTO;
import com.example.clinica_v6.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    ObjectMapper mapper;


    public User crearUser(UserDTO userDTO) {

        User user = mapper.convertValue(userDTO, User.class);
        repository.save(user);

        return user;
    }


    public UserDTO searchUser(Long id) {
        Optional<User> user = repository.findById(id);
        UserDTO userDTO = null;
        if(user.isPresent())
            userDTO = mapper.convertValue(user,UserDTO.class);

        return userDTO;

    }


    public void updateUser(UserDTO userDTO) {
        User user = mapper.convertValue(userDTO, User.class);
        repository.save(user);

    }


    public void remove(Long id) {

        repository.deleteById(id);

    }


    public Set<UserDTO> getTodos() {

        List<User> users = repository.findAll();
        Set<UserDTO> usersDTO = new HashSet<>();

        for(User user: users){
            usersDTO.add(mapper.convertValue(user, UserDTO.class));
        }

        return usersDTO;

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return repository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("no se encontro username"));
    }
}
