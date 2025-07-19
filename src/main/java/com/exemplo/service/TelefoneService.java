package com.exemplo.service;

import com.exemplo.dominio.Projeto;
import com.exemplo.dominio.Telefone;
import com.exemplo.dominio.Usuario;
import com.exemplo.entidade.TelefoneEntity;
import com.exemplo.entidade.UsuarioEntity;
import com.exemplo.mapper.TelefoneEntityMapper;
import com.exemplo.mapper.UsuarioEntityMapper;
import com.exemplo.repository.TelefoneRepository;
import com.exemplo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;
    private final TelefoneEntityMapper telefoneEntityMapper;



    public Telefone salvar(Telefone telefone) {
//        if (usuario.getId() == null) {
//            usuario.setId(UUID.randomUUID()); // Gera novo UUID
//        }
        TelefoneEntity entity = telefoneEntityMapper.toEntity(telefone);
        TelefoneEntity salvo = telefoneRepository.save(entity);
        return telefoneEntityMapper.toDomain(salvo);
    }

    public Optional<Telefone> buscarPorId(Long id) {
        Optional<Telefone> telefone = telefoneRepository.findById(id).map(telefoneEntityMapper::toDomain);
        System.out.println(telefone);
        return telefone;
    }

    public List<Telefone> listarTodos() {
        return telefoneRepository.findAll()
                .stream()
                .map(telefoneEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public void salvarListaTelefone(List<Telefone> telefone, Projeto id) {
        telefone.forEach(t -> {
            t.setProjeto(id);
            this.salvar(t);
        });
    }
}
