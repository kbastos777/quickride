package com.quickride.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quickride.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}