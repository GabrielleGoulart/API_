package com.example.Biblioteca.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Biblioteca.Model.Bibliotecario;
import com.example.Biblioteca.Repository.BibliotecarioRepository;

@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public List<Bibliotecario> findAllBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public Bibliotecario saveBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public void deleteBibliotecario(Long id) {
        bibliotecarioRepository.deleteById(id);
    }

    public List<Bibliotecario> listar() {
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    public void deletar(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    public Object buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }
}