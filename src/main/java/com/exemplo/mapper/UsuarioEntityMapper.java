package com.exemplo.mapper;

import com.exemplo.dominio.Usuario;
import com.exemplo.entidade.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {
    UsuarioEntity toEntity(Usuario usuario);
    Usuario toDomain(UsuarioEntity entity);
}
