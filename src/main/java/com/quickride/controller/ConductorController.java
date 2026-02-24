package com.quickride.controller;

import com.quickride.model.Conductor;
import com.quickride.repository.ConductorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conductores")
public class ConductorController {

    private final ConductorRepository conductorRepository;

    public ConductorController(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    @PostMapping
    public Conductor crearConductor(@RequestBody Conductor conductor) {
        conductor.setDisponible(true);
        return conductorRepository.save(conductor);
    }
}
