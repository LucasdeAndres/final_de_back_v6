package com.example.clinica_v6.repository;

import com.example.clinica_v6.entidades.Odontologo;
import com.example.clinica_v6.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByDNI(String dni);

}
