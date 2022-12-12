package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.Turno;
import com.example.clinica_v6.entidades.TurnoDTO;
import com.example.clinica_v6.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class TurnoService implements TurnoServiceInterface{

    private TurnoRepository repository;

    ObjectMapper mapper;

    @Override
    public Turno add(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        repository.save(turno);

        return turno;
    }

    @Override
    public TurnoDTO searchTurno(Long id) {
        Optional<Turno> turno = repository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent())
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);

        return turnoDTO;
    }

    @Override
    public void update(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        repository.save(turno);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> getTodos() {
        List<Turno> turnos = repository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for(Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }

        return turnosDTO;
    }
}

