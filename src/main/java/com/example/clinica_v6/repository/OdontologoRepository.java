package com.example.clinica_v6.repository;

import com.example.clinica_v6.entidades.Odontologo;
import com.example.clinica_v6.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    Optional<Odontologo> findByMatricula(String matricula);

}