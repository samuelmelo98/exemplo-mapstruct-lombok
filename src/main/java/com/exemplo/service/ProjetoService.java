package com.exemplo.service;

import com.exemplo.dominio.Projeto;
import com.exemplo.dominio.Usuario;
import com.exemplo.entidade.ProjetoEntity;
import com.exemplo.entidade.UsuarioEntity;
import com.exemplo.mapper.ProjetoEntityMapper;
import com.exemplo.mapper.UsuarioEntityMapper;
import com.exemplo.repository.ProjetoRepository;
import com.exemplo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoEntityMapper projetoEntityMapper;
    private final UsuarioEntityMapper usuarioEntityMapper;

    public Projeto salvar(Projeto projeto) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(projeto.getUsuario().getId())
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        ProjetoEntity entity = projetoEntityMapper.toEntity(projeto);
        entity.setUsuario(usuarioEntity);

        ProjetoEntity salvo = projetoRepository.save(entity);
        return projetoEntityMapper.toDomain(salvo);
    }

    public Optional<Projeto> buscarPorId(UUID id) {
        return projetoRepository.findById(id).map(projetoEntityMapper::toDomain);
    }
}
