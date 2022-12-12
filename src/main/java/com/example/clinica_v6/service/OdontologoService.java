package com.example.clinica_v6.service;


import com.example.clinica_v6.entidades.Odontologo;
import com.example.clinica_v6.entidades.OdontologoDTO;
import com.example.clinica_v6.excepciones.ResourceBadRequestException;
import com.example.clinica_v6.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class OdontologoService implements OdontologoServiceInterface{


    private OdontologoRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO) {

        if(repository.findByMatricula(odontologoDTO.getMatricula()).isPresent()){
            try {
                throw new ResourceBadRequestException("la matricula ya existe");
            } catch (ResourceBadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        repository.save(odontologo);

        return odontologo;
    }

    @Override
    public OdontologoDTO searchOdontologo(Long id) {
        Optional<Odontologo> odontologo = repository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);

        return odontologoDTO;

    }

    @Override
    public void updateOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        repository.save(odontologo);

    }

    @Override
    public void remove(Long id) {

        repository.deleteById(id);

    }

    @Override
    public Set<OdontologoDTO> getTodos() {

        List<Odontologo> odontologos = repository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for(Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }

        return odontologosDTO;

    }


}
