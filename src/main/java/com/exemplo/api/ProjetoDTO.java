package com.exemplo.api;

import com.exemplo.dominio.Telefone;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ProjetoDTO {
    private UUID id;
    private String nome;
    private UUID usuarioId;
    private List<Telefone> telefones = new ArrayList<>();
}
