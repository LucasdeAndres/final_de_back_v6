package com.example.clinica_v6.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Pacientes")
public class Paciente {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre, apellido, email, dni;
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;

}
