package com.exemplo.service;

import com.exemplo.api.ProjetoDTO;
import com.exemplo.dominio.Projeto;
import com.exemplo.entidade.ProjetoEntity;
import com.exemplo.entidade.UsuarioEntity;
import com.exemplo.mapper.ProjetoEntityMapper;
import com.exemplo.mapper.ProjetoListagemMapper;
import com.exemplo.mapper.UsuarioEntityMapper;
import com.exemplo.repository.ProjetoRepository;
import com.exemplo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjetoDTOService {
    private final ProjetoRepository projetoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoEntityMapper projetoEntityMapper;
    private final ProjetoListagemMapper projetoListagemEntityMapper;
    private final UsuarioEntityMapper usuarioEntityMapper;

    public Projeto salvar(ProjetoDTO projetoDTO) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(projetoDTO.getUsuarioId())
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        ProjetoEntity entity = projetoListagemEntityMapper.toEntity(projetoDTO);
        entity.setUsuario(usuarioEntity);

        ProjetoEntity salvo = projetoRepository.save(entity);
        return projetoEntityMapper.toDomain(salvo);
    }

    public Optional<Projeto> buscarPorId(UUID id) {
        ProjetoEntity projetoEntity = projetoRepository.findById(id).get();
        Projeto projeto = projetoRepository.findById(id).map(projetoEntityMapper::toDomain).get();
        ProjetoDTO projetoDTO = new ProjetoDTO();
        projetoDTO.setId(projetoEntity.getId());
        projetoDTO.setNome("projetoListagemEntityMapper");
        projetoDTO.setTelefones(projeto.getTelefones());
        ProjetoEntity projetoEntity1 = projetoListagemEntityMapper.toEntity(projetoDTO);
        this.salvar(projetoDTO);
        return projetoRepository.findById(id).map(projetoEntityMapper::toDomain);
    }

    public List<Projeto> listaTodos() {
        List<ProjetoEntity> projetoEntities = projetoRepository.findAllComTelefones();
        projetoEntities.size();
        return projetoEntityMapper.toDomainList(projetoEntities);
    }

}
