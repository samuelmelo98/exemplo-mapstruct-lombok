package com.exemplo.mapper;

import com.exemplo.dominio.Telefone;
import com.exemplo.entidade.TelefoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
//        ProjetoEntityMapper.class
})
public interface TelefoneEntityMapper {
    @Mapping(target = "projeto", ignore = true)
    TelefoneEntity toEntity(Telefone telefone);
    @Mapping(target = "projeto", ignore = true)
    Telefone toDomain(TelefoneEntity entity);
}
