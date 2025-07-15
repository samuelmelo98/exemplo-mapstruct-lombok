package com.exemplo.dominio;

import lombok.Data;
import java.util.UUID;

@Data
public class Projeto {
    private UUID id;
    private String nome;
    private Usuario usuario;
}
