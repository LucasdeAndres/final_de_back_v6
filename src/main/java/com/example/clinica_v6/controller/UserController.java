package com.example.clinica_v6.controller;

import com.example.clinica_v6.entidades.User;
import com.example.clinica_v6.excepciones.ResourceNotFoundException;
import com.example.clinica_v6.jwt.JwtUtil;
import com.example.clinica_v6.security.AuthenticationRequest;
import com.example.clinica_v6.security.AuthenticationResponse;
import com.example.clinica_v6.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<User>> searchAll (){

        return ResponseEntity.ok().body(service.getTodos());
    }

    @PostMapping("/nuevosUsers")
    public ResponseEntity<?> add(@RequestBody User user){
        return ResponseEntity.ok().body(service.crearUser(user));
    }

    @PutMapping("/modificarUser")
    public void update (@RequestBody User user){
        service.updateUser(user);
    }

    @DeleteMapping("/eliminarUser/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id) throws ResourceNotFoundException {
        if(id == null){
            String mensajeError = "NO se encuentra el User con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.remove(id);
        return ResponseEntity.ok(id + " fue eliminado");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> searchUser ( @PathVariable Long id) throws ResourceNotFoundException {
        if(id == null){
            String mensajeError = "NO se encuentra el user con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.searchUser(id);
        return ResponseEntity.ok(service.searchUser(id));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> autenticarUser (@RequestBody AuthenticationRequest authenticationRequest ) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception("Incorrect", e);
        }
        final UserDetails userDetails = service.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse((jwt)));
    }

}