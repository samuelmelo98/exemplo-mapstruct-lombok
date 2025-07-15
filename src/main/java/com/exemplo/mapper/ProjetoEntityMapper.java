package com.exemplo.mapper;

import com.exemplo.dominio.Projeto;
import com.exemplo.entidade.ProjetoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UsuarioEntityMapper.class)
public interface ProjetoEntityMapper {
    ProjetoEntity toEntity(Projeto projeto);
    Projeto toDomain(ProjetoEntity entity);
}
