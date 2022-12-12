package com.example.clinica_v6.controller;

import com.example.clinica_v6.excepciones.ResourceNotFoundException;
import com.example.clinica_v6.entidades.Turno;
import com.example.clinica_v6.entidades.TurnoDTO;
import com.example.clinica_v6.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/turno")
public class TurnoController {

    private final TurnoService service;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Set<TurnoDTO>> searchAll (){

        return ResponseEntity.ok().body(service.getTodos());
    }

    @PostMapping("/nuevosTurnos")
    public ResponseEntity<Turno> add(@RequestBody TurnoDTO turnoDTO){
        return ResponseEntity.ok().body(service.add(turnoDTO));
    }

    @PutMapping("/modificarTurno")
    public void update (@RequestBody TurnoDTO turnoDTO){

        service.update(turnoDTO);
    }

    @DeleteMapping("/eliminarTurno/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id) throws ResourceNotFoundException {
        if(id == null){
            String mensajeError = "NO se encuentra el turno con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.remove(id);
        return ResponseEntity.ok(id + " fue eliminado");
    }

    @GetMapping("/turno/{id}")
    public ResponseEntity<?> searchTurno (@PathVariable Long id) throws ResourceNotFoundException {
        if(id == null){
            String mensajeError = "NO se encuentra el turno con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.searchTurno(id);
        return ResponseEntity.ok(service.searchTurno(id));
    }

}