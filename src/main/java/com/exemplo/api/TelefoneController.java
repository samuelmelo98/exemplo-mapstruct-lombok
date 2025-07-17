package com.exemplo.api;

import com.exemplo.dominio.Telefone;
import com.exemplo.entidade.TelefoneEntity;
import com.exemplo.repository.TelefoneRepository;
import com.exemplo.service.TelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/telefones")
@RequiredArgsConstructor
public class TelefoneController {

    private final TelefoneRepository telefoneRepository;
    private final TelefoneService telefoneService;

    @GetMapping
    public List<TelefoneEntity> listarTodos() {
        return telefoneRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneEntity> buscarPorId(@PathVariable Long id) {
        return telefoneRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Telefone> salvar(@RequestBody Telefone telefone) {
        Telefone salvo = telefoneService.salvar(telefone);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TelefoneEntity> atualizar(@PathVariable Long id, @RequestBody TelefoneEntity telefone) {
        Optional<TelefoneEntity> existente = telefoneRepository.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        TelefoneEntity entity = existente.get();
        entity.setNumero(telefone.getNumero());
        entity.setTipo(telefone.getTipo());
        entity.setProjeto(telefone.getProjeto());

        return ResponseEntity.ok(telefoneRepository.save(entity));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!telefoneRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        telefoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
