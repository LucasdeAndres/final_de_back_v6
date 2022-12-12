package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.Paciente;
import com.example.clinica_v6.entidades.PacienteDTO;

import java.util.Set;

public interface PacienteServiceInterface {


    Paciente add(PacienteDTO pacienteDTO);
    PacienteDTO searchPaciente(Long id);
    void updatePaciente(PacienteDTO pacienteDTO);
    void remove(Long id);
    Set<PacienteDTO> getTodos();

}
