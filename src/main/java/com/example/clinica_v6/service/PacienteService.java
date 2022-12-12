package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.Paciente;
import com.example.clinica_v6.entidades.PacienteDTO;
import com.example.clinica_v6.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class PacienteService implements PacienteServiceInterface{

    private PacienteRepository repository;

    ObjectMapper mapper;

    @Override
    public Paciente add(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        repository.save(paciente);
        return paciente;
    }

    @Override
    public PacienteDTO searchPaciente(Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);

        return pacienteDTO;

    }

    @Override
    public void updatePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        repository.save(paciente);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> getTodos() {
        List<Paciente> pacientes = repository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for(Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }

        return pacientesDTO;
    }
}
