package com.quickride.repository;

import com.quickride.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {

    Optional<Conductor> findFirstByDisponibleTrue();
}
