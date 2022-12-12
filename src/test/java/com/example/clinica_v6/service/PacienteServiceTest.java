package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.PacienteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteServiceInterface servicePaciente;

    PacienteServiceTest() {
    }

    @Test
    public void testCrearPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juan");
        pacienteDTO.setApellido("Rodriguez");
        pacienteDTO.setEmail("email.com");
        pacienteDTO.setDni("13456789");
        pacienteDTO.setFechaIngreso(LocalDate.now());
        this.servicePaciente.add(pacienteDTO);
        PacienteDTO pacienteJuan = this.servicePaciente.searchPaciente(1L);
        Assertions.assertTrue(pacienteJuan != null);
    }
}