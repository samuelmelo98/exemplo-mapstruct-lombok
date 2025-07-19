package com.exemplo.dominio;

import com.exemplo.service.TelefoneService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {
    private Long id;
    private String numero;
    private String tipo;
    private Projeto projeto; // Associa apenas o ID do projeto, mantendo o domínio isolado


}
