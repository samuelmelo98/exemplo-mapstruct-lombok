package com.exemplo.repository;

import com.exemplo.entidade.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProjetoRepository extends JpaRepository<ProjetoEntity, UUID> {
    @Query("SELECT DISTINCT p FROM ProjetoEntity p LEFT JOIN FETCH p.telefones")
    List<ProjetoEntity> findAllComTelefones();
}
