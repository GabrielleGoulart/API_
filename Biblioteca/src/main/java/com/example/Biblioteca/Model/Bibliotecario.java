package com.example.Biblioteca.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Bibliotecario")
@Getter
@Setter
@NoArgsConstructor

public class Bibliotecario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Bibliotecario;

    @Column
    private String nome;
    @Column
    private String Email;
   
}