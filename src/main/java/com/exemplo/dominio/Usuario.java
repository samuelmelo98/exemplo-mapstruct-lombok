package com.exemplo.dominio;
import lombok.Data;

import java.util.UUID;

@Data
public class Usuario {

    public Usuario(){};
    private UUID id;
    private String nome;
    private String email;
}
