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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getConductorNombre() {
        return conductorNombre;
    }

    public void setConductorNombre(String conductorNombre) {
        this.conductorNombre = conductorNombre;
    }

    public EstadoViaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoViaje estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
