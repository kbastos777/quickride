package com.quickride.repository;

import com.quickride.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {

    List<Viaje> findByUsuarioId(Long usuarioId);
}
