package com.EscolaAluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EscolaAluno.model.Aluno;
import com.example.EscolaAluno.service.Alunoservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/EscolaAluno")
public class Alunocontroller{

@Autowired
private Alunoservice service;

@GetMapping
public List<repository.Aluno> listarTodos(){
    return service.listarTodosAlunos();

}
@GetMapping("/{id}")
public ResponseEntity<repository.Aluno> buscaporId(@PathVariable long id) {
return service.buscarAlunoPorId(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());

}
@PostMapping
public Aluno salvar(@RequestBody Aluno Aluno){
    return service.salvar(Aluno);
}

@PutMapping("/{id}")
public ResponseEntity<Aluno> atualizar (Long id) {
ResponseEntity<Aluno> entity = null;
return entity;
}
    
}



