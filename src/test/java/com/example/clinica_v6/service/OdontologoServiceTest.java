package com.example.clinica_v6.service;

import com.example.clinica_v6.entidades.OdontologoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoServiceInterface service;

    OdontologoServiceTest() {
    }

    @Test
    public void testCrearOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Carlos");
        odontologoDTO.setApellido("Bernal");
        odontologoDTO.setMatricula("456181384");
        this.service.crearOdontologo(odontologoDTO);
        OdontologoDTO odonCarlos = this.service.searchOdontologo(1L);
        Assertions.assertTrue(odonCarlos != null);
    }
}