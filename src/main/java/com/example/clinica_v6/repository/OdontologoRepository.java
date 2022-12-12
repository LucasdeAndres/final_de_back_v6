package com.example.clinica_v6.repository;

import com.example.clinica_v6.entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}