package com.example.clinica_v6.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String nombre,username,email,password;
    private Roles roles;

}
