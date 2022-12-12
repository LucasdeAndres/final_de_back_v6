package com.example.clinica_v6.entidades;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String nombre, apellido, email, dni;
    private LocalDate fechaIngreso;


}