package com.exemplo.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {
    private Long id;
    private String numero;
    private String tipo;
    private UUID projetoId; // Associa apenas o ID do projeto, mantendo o domínio isolado
}
