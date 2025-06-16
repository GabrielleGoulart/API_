package com.example.Biblioteca.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Biblioteca.Model.Bibliotecario;
import com.example.Biblioteca.Service.BibliotecarioService;


@RestController
@RequestMapping("/api/Bibliotecario")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService service;

    @GetMapping
    public List<Bibliotecario> listar() {
        return service.listar();
    }

    @PostMapping
    public Bibliotecario cadastrar(@RequestBody Bibliotecario bibliotecario) {
        return service.salvar(bibliotecario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> atualizar(@PathVariable Long id, @RequestBody Bibliotecario bibliotecarioAtualizado) {
        return service.buscarPorId(id) // procura no banco
                .map(bibliotecarioExistente -> {
                    bibliotecarioExistente.setNome(bibliotecarioAtualizado.getNome());
                    bibliotecarioExistente.setEmail(bibliotecarioAtualizado.getEmail());
                    Bibliotecario bibliotecarioSalvo = service.salvar(bibliotecarioExistente);
                    return ResponseEntity.ok(bibliotecarioSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}