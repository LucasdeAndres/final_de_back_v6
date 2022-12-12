package com.example.clinica_v6.controller;

import com.example.clinica_v6.entidades.OdontologoDTO;
import com.example.clinica_v6.service.OdontologoService;
import com.example.clinica_v6.excepciones.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/odontologo")
@Slf4j
public class OdontologoController {

    private final OdontologoService service;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Set<OdontologoDTO>> searchAll (){

        return ResponseEntity.ok().body(service.getTodos());
    }

    @PostMapping("/nuevosOdontologos")
    public ResponseEntity<?> add(@RequestBody OdontologoDTO odontologoDTO){
        log.info("se esta creando el odontologo");
        return ResponseEntity.ok().body(service.crearOdontologo(odontologoDTO));
    }

    @PutMapping("/modificarOdontologo")
    public void update (@RequestBody OdontologoDTO odontologoDTO){
        service.updateOdontologo(odontologoDTO);
    }

    @DeleteMapping("/eliminarOdontologo/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id) throws ResourceNotFoundException {
        log.info("se esta eliminando el odontologo");
        if(id == null){
            String mensajeError = "NO se encuentra el odontologo con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.remove(id);
        return ResponseEntity.ok(id + " fue eliminado");
    }

    @GetMapping("/odontologo/{id}")
    public ResponseEntity<?> searchOdontologo ( @PathVariable Long id) throws ResourceNotFoundException {
        if(id == null){
            String mensajeError = "NO se encuentra el odontologo con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.searchOdontologo(id);
        return ResponseEntity.ok(service.searchOdontologo(id));
    }

}
