package com.exemplo.mapper;

import com.exemplo.dominio.Telefone;
import com.exemplo.entidade.TelefoneEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneEntityMapper {
    TelefoneEntity toEntity(Telefone telefone);
    Telefone toDomain(TelefoneEntity entity);
}
