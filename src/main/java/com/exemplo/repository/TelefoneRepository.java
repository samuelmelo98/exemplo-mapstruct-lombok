package com.exemplo.repository;

import com.exemplo.dominio.Telefone;
import com.exemplo.entidade.TelefoneEntity;
import com.exemplo.entidade.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {


}
