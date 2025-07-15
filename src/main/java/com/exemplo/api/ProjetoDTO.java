package com.exemplo.api;

import lombok.Data;
import java.util.UUID;

@Data
public class ProjetoDTO {
    private UUID id;
    private String nome;
    private UUID usuarioId;
}
