package com.example.clinica_v6.controller;

import com.example.clinica_v6.excepciones.ResourceNotFoundException;
import com.example.clinica_v6.entidades.Paciente;
import com.example.clinica_v6.entidades.PacienteDTO;
import com.example.clinica_v6.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Set<PacienteDTO>> searchAll (){

        return ResponseEntity.ok().body(service.getTodos());
    }

    @PostMapping("/nuevoPaciente")
    public ResponseEntity<Paciente> add(@RequestBody PacienteDTO pacienteDTO){
        return ResponseEntity.ok().body(service.add(pacienteDTO));
    }

    @PutMapping("/modificarPaciente")
    public void updatePaciente (@RequestBody PacienteDTO pacienteDTO){

        service.updatePaciente(pacienteDTO);
    }

    @DeleteMapping("/eliminarPaciente/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id) throws ResourceNotFoundException {
        if(id == null){
            String mensajeError = "NO se encuentra el paciente con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.remove(id);
        return ResponseEntity.ok(id + " fue eliminado");
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<?> searchPaciente (@PathVariable Long id) throws ResourceNotFoundException {
        if(id == null){
            String mensajeError = "NO se encuentra el paciente con id :" + id;
            throw new ResourceNotFoundException(mensajeError);
        }
        service.searchPaciente(id);
        return ResponseEntity.ok(service.searchPaciente(id));
    }

}
