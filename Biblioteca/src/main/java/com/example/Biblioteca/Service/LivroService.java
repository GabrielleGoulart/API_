package com.example.Biblioteca.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Biblioteca.Model.Bibliotecario;
import com.example.Biblioteca.Model.Livro;
import com.example.Biblioteca.Repository.BibliotecarioRepository;
import com.example.Biblioteca.Repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository; // To link books to librarians

    public List<Livro> findAllLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro saveLivro(Livro livro, Long bibliotecarioId) {
        if (bibliotecarioId != null) {
            Optional<Bibliotecario> bibliotecario = bibliotecarioRepository.findById(bibliotecarioId);
            if (bibliotecario.isPresent()) {
                livro.setBibliotecarioResponsavel(bibliotecario.get());
            } else {
                throw new IllegalArgumentException("Bibliotecário com ID " + bibliotecarioId + " não encontrado.");
            }
        }
        return livro;
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    public Livro salvar(Livro livro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    public Object buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
}
