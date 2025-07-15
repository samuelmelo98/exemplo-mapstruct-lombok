//package com.exemplo.mapperImplement;
//
//import com.exemplo.dominio.Usuario;
//import com.exemplo.entidade.UsuarioEntity;
//import com.exemplo.mapper.UsuarioEntityMapper;
//
//public class UsuarioMapperImpl  implements UsuarioEntityMapper {
//    @Override
//    public UsuarioEntity toEntity(Usuario usuario) {
//        if(usuario == null){
//            return null;
//        }
//        UsuarioEntity  usuarioEntity = new UsuarioEntity();
//         usuarioEntity.setId(usuario.getId());
//         usuarioEntity.setNome(usuario.getNome());
//         usuarioEntity.setEmail(usuario.getNome());
//         return usuarioEntity;
//    }
//
//    @Override
//    public Usuario toDomain(UsuarioEntity entity) {
//        return null;
//    }
//}
