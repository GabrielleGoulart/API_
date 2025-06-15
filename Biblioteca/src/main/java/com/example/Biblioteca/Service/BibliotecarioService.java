package com.example.Biblioteca.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public List<Bibliotecario> findAllBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<Bibliotecario> findBibliotecarioById(Long id) {
        return BibliotecarioRepository.findById(id);
    }

    public Bibliotecario saveBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public Bibliotecario updateBibliotecario(Long id, Bibliotecario bibliotecarioDetails) {
        return BibliotecarioRepository.findById(id)
                .map(bibliotecario -> {
                    bibliotecario.setNome(bibliotecarioDetails.getNome());
                    bibliotecario.setEmail(bibliotecarioDetails.getEmail());
                    return bibliotecarioRepository.save(bibliotecario);
                }).orElse(null); // Or throw a custom exception
    }

    public void deleteBibliotecario(Long id) {
        BibliotecarioRepository.deleteById(id);
    }
}