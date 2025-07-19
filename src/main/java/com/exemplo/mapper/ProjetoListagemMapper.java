package com.exemplo.mapper;

import com.exemplo.api.ProjetoDTO;
import com.exemplo.entidade.ProjetoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {
        UsuarioEntityMapper.class,
        TelefoneEntityMapper.class
})
public interface ProjetoListagemMapper {
    ProjetoDTO toDTO(ProjetoEntity entity);
    ProjetoEntity toEntity(ProjetoDTO dto);

    @Named("projetoLista")
    default ProjetoEntity mapProjetoId(UUID id) {
        if (id == null) return null;
        ProjetoEntity projeto = new ProjetoEntity();
        projeto.setId(id);
        return projeto;
    }

}
