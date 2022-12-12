package com.example.clinica_v6.entidades;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "Turno")
public class Turno {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "odontologo_id",nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id",nullable = false)
    private Paciente paciente;

    private LocalDate fecha;

}
