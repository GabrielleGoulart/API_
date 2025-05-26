package com.example.EscolaAluno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.example.EscolaAluno.model.Aluno;

import repository.Alunorepository;

import java.util.List;
import java.util.Optional;

@Service 
public class Alunoservice {

    @Autowired 
    private Alunorepository alunoRepository;

    public List<repository.Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }


    public Optional<repository.Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    @Transactional
    public Aluno cadastrarAluno(repository.Aluno aluno) {
  
        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do aluno é obrigatório.");
        }
       
        return alunoRepository.saveAll(aluno);
    }

    
    @Transactional
    public repository.Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        Optional<repository.Aluno> alunoExistenteOptional = alunoRepository.findById(id);

        if (alunoExistenteOptional.isPresent()) {
            repository.Aluno alunoExistente = alunoExistenteOptional.get();

            
            alunoExistente.setEmail(alunoAtualizado.getEmail());

            
            return alunoRepository.save(alunoExistente);
        }
        
        return null; 
    }

   
    @Transactional
    public boolean deletarAluno(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false; 
    }

    public com.example.EscolaAluno.model.Aluno salvar(com.example.EscolaAluno.model.Aluno aluno) {
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }
}
 

