package com.exemplo.api;

import com.exemplo.dominio.Projeto;
import com.exemplo.dominio.Usuario;
import com.exemplo.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @GetMapping
    public List<Projeto> listarTodos() {
         List<Projeto> projetos  = projetoService.listaTodos();
        return projetos;
    }

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody ProjetoDTO dto) {
        Projeto projeto = new Projeto();
        projeto.setId(dto.getId() != null ? dto.getId() : UUID.randomUUID());
        projeto.setNome(dto.getNome());

        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuarioId());
        projeto.setUsuario(usuario);

        Projeto salvo = projetoService.salvar(projeto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscar(@PathVariable UUID id) {
        return projetoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizar(@PathVariable UUID id, @RequestBody ProjetoDTO dto) {
        Optional<Projeto> existente = projetoService.buscarPorId(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Projeto projeto = existente.get();
        projeto.setNome(dto.getNome());

        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuarioId());
        projeto.setUsuario(usuario);

        Projeto atualizado = projetoService.salvar(projeto);
        return ResponseEntity.ok(atualizado);
    }
}
