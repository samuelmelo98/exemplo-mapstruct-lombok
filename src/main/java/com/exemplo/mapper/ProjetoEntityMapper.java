package com.exemplo.mapper;

import com.exemplo.dominio.Projeto;
import com.exemplo.entidade.ProjetoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsuarioEntityMapper.class)
public interface ProjetoEntityMapper {
    ProjetoEntity toEntity(Projeto projeto);
    Projeto toDomain(ProjetoEntity entity);
    List<ProjetoEntity> toEntityList(List<Projeto> projetos);

    List<Projeto> toDomainList(List<ProjetoEntity> entities);
}
