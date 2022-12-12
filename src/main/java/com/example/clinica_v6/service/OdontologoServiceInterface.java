package com.example.clinica_v6.service;


import com.example.clinica_v6.entidades.Odontologo;
import com.example.clinica_v6.entidades.OdontologoDTO;

import java.util.Set;

public interface OdontologoServiceInterface {
    Odontologo crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO searchOdontologo(Long id);
    void updateOdontologo(OdontologoDTO odontologoDTO);
    void remove(Long id);
    Set<OdontologoDTO> getTodos();
}
