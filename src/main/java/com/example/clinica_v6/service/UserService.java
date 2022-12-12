package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.User;
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


    public User crearUser(User user) {

        var appUser = new User(null, user.getNombre(),user.getUsername(), user.getEmail(), passwordEncoder.encode(user.getPassword()), user.getRoles());
        repository.save(appUser);

        return appUser;
    }


    public Optional<User> searchUser(Long id) {
        Optional<User> user = repository.findById(id);

        return user;

    }


    public void updateUser(User user) {

        repository.save(user);

    }


    public void remove(Long id) {

        repository.deleteById(id);

    }


    public List<User> getTodos() {

        List<User> users = repository.findAll();

        return users;

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return repository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("no se encontro username"));
    }
}
