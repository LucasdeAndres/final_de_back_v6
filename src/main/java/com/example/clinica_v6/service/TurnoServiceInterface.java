package com.example.clinica_v6.service;


import com.example.clinica_v6.entidades.Turno;
import com.example.clinica_v6.entidades.TurnoDTO;

import java.util.Set;

public interface TurnoServiceInterface {

    Turno add(TurnoDTO turnoDTO);
    TurnoDTO searchTurno(Long id);
    void update(TurnoDTO turnoDTO);
    void remove(Long id);
    Set<TurnoDTO> getTodos();

}
