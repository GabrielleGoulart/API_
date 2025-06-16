package com.example.Biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.Model.Livro;
import com.example.Biblioteca.Service.LivroService;

@RestController
@RequestMapping("/api/livro")

public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> listar() {
        return service.listar();
    
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) {
        return service.salvar(livro);

    }

    @GetMapping("/{id}")
     public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
       return ((Object) service.buscarPorId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); 
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

   @PutMapping("/{id}")
public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
    return service.buscarPorId(id)  // procura no banco
            .map(livroExistente -> {
                livroExistente.setTitulo(livroAtualizado.getTitulo());
                livroExistente.setAutor(livroAtualizado.getAutor());
                livroExistente.setGenero(livroAtualizado.getGenero());
                livroExistente.setStatus(livroAtualizado.getStatus());
                livroExistente.setDataDeCadastro(livroAtualizado.getDataDeCadastro());
                LivroModel livroSalvo = service.salvar(livroExistente);   // salva no banco
                return ResponseEntity.ok(livroSalvo);                // retorna OK com o livro atualizado
            })
            .orElse(ResponseEntity.notFound().build()); // se não achar retorna 404
}

}