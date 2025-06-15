package com.example.Biblioteca.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Livro")
@Getter
@Setter
@NoArgsConstructor

public class Livro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_Livro;

    @Id
    private int ID_Bibliotecario_Responsavel;
    
    @Column
    private String Titulo;
    @Column
    private String Autor;
    @Column 
    private String Genero;
    @Column(name = "Status", nullable = false)
    private String status;
    @Column(name = "DataDeCadastro", nullable = false)
    private LocalDateTime dataDeCadastro;

    @PrePersist
    public void prePersist() {
        if (dataDeCadastro == null) {
            dataDeCadastro = LocalDateTime.now();
        }

    }

    public void setBibliotecarioResponsavel(Bibliotecario bibliotecario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBibliotecarioResponsavel'");
    }
}
