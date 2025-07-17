package com.exemplo.repository;

import com.exemplo.entidade.TelefoneEntity;
import com.exemplo.entidade.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {
}
