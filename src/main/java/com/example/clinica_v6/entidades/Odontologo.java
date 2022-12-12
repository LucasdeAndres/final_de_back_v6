package com.example.clinica_v6.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "Estudiantes")
public class Odontologo {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre,apellido,matricula;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;

}