package com.exemplo.service;

import com.exemplo.dominio.Usuario;
import com.exemplo.entidade.UsuarioEntity;
import com.exemplo.mapper.UsuarioEntityMapper;
import com.exemplo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;



    public Usuario salvar(Usuario usuario) {
//        if (usuario.getId() == null) {
//            usuario.setId(UUID.randomUUID()); // Gera novo UUID
//        }
        UsuarioEntity entity = usuarioEntityMapper.toEntity(usuario);
        UsuarioEntity salvo = usuarioRepository.save(entity);
        return usuarioEntityMapper.toDomain(salvo);
    }

    public Optional<Usuario> buscarPorId(UUID id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id).map(usuarioEntityMapper::toDomain);
        System.out.println(usuario);
        return usuario;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
