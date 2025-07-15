package com.exemplo.repository;

import com.exemplo.entidade.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProjetoRepository extends JpaRepository<ProjetoEntity, UUID> {}
