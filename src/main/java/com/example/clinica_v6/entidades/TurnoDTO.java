package com.example.clinica_v6.entidades;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurnoDTO {

    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDate fecha;
}

