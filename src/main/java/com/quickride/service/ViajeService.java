package com.quickride.service;

import com.quickride.dto.ViajeRequestDTO;
import com.quickride.dto.ViajeResponseDTO;
import com.quickride.model.Conductor;
import com.quickride.model.EstadoViaje;
import com.quickride.model.Usuario;
import com.quickride.model.Viaje;
import com.quickride.repository.ConductorRepository;
import com.quickride.repository.UsuarioRepository;
import com.quickride.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService {

    private final ViajeRepository viajeRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConductorRepository conductorRepository;

    public ViajeService(ViajeRepository viajeRepository,
                        UsuarioRepository usuarioRepository,
                        ConductorRepository conductorRepository) {
        this.viajeRepository = viajeRepository;
        this.usuarioRepository = usuarioRepository;
        this.conductorRepository = conductorRepository;
    }

    public ViajeResponseDTO crearViaje(ViajeRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Conductor conductor = conductorRepository.findFirstByDisponibleTrue()
                .orElseThrow(() -> new RuntimeException("No hay conductores disponibles"));

        conductor.setDisponible(false);

        Viaje viaje = new Viaje();
        viaje.setOrigen(dto.getOrigen());
        viaje.setDestino(dto.getDestino());
        viaje.setDistanciaKm(dto.getDistanciaKm());
        viaje.setUsuario(usuario);
        viaje.setConductor(conductor);

        double tarifa = calcularTarifa(dto.getDistanciaKm());
        viaje.setTarifa(tarifa);
        viaje.setEstado(EstadoViaje.CONDUCTOR_ASIGNADO);

        viajeRepository.save(viaje);

        return new ViajeResponseDTO(
                viaje.getId(),
                viaje.getOrigen(),
                viaje.getDestino(),
                viaje.getTarifa(),
                conductor.getNombre(),
                viaje.getEstado(),
                viaje.getFechaSolicitud()
        );
    }

    public List<ViajeResponseDTO> historialUsuario(Long usuarioId) {

        return viajeRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(viaje -> new ViajeResponseDTO(
                        viaje.getId(),
                        viaje.getOrigen(),
                        viaje.getDestino(),
                        viaje.getTarifa(),
                        viaje.getConductor().getNombre(),
                        viaje.getEstado(),
                        viaje.getFechaSolicitud()
                ))
                .toList();
    }


    private double calcularTarifa(double distanciaKm) {
        double tarifaBase = 2.5;
        double precioPorKm = 1.2;
        return tarifaBase + (distanciaKm * precioPorKm);
    }
}
