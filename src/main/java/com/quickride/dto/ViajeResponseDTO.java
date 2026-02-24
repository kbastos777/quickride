package com.quickride.dto;

import com.quickride.model.EstadoViaje;

import java.time.LocalDateTime;

public class ViajeResponseDTO {

    private Long id;
    private String origen;
    private String destino;
    private double tarifa;
    private String conductorNombre;
    private EstadoViaje estado;
    private LocalDateTime fechaSolicitud;

    // Constructor
    public ViajeResponseDTO(Long id, String origen, String destino,
                            double tarifa, String conductorNombre,
                            EstadoViaje estado, LocalDateTime fechaSolicitud) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.tarifa = tarifa;
        this.conductorNombre = conductorNombre;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
    }

    // Getters
}
