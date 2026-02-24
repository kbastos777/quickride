package com.quickride.service;

import com.quickride.model.EstadoViaje;
import com.quickride.model.Viaje;
import com.quickride.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ViajeService {

    private final ViajeRepository viajeRepository;

    public ViajeService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    // Crear viaje
    public Viaje crearViaje(Viaje viaje) {
        double tarifa = calcularTarifa(viaje.getDistanciaKm());
        viaje.setTarifa(tarifa);

        asignarConductor(viaje);

        return viajeRepository.save(viaje);
    }

    // Lógica de tarifa
    private double calcularTarifa(double distanciaKm) {

        double tarifaBase = 2.50;
        double precioPorKm = 1.20;

        return tarifaBase + (distanciaKm * precioPorKm);
    }

    // Asignación automática de conductor
    private void asignarConductor(Viaje viaje) {

        List<String> conductoresDisponibles = List.of(
                "Carlos",
                "María",
                "José",
                "Andrea"
        );

        Random random = new Random();
        String conductor = conductoresDisponibles.get(
                random.nextInt(conductoresDisponibles.size())
        );

        viaje.setConductorAsignado(conductor);
        viaje.setEstado(EstadoViaje.CONDUCTOR_ASIGNADO);
    }
}
