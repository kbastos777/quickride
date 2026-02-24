package com.quickride.controller;

import com.quickride.dto.ViajeRequestDTO;
import com.quickride.dto.ViajeResponseDTO;
import com.quickride.model.Viaje;
import com.quickride.service.ViajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @PostMapping
    public ViajeResponseDTO crearViaje(@RequestBody ViajeRequestDTO dto) {
        return viajeService.crearViaje(dto);
    }

    @GetMapping("/usuario/{id}")
    public List<Viaje> historial(@PathVariable Long id) {
        return viajeService.historialUsuario(id);
    }
}
