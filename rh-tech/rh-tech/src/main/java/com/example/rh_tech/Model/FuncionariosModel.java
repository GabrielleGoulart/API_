
package com.example.rh_tech.Model;
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
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
public class funcionariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String cep;

    @Column
    private String endereco;

    @Column
    private String numero;

    @Column
    private String bairro;

     @Column
    private String cidade;

    @Column
    private String estado;  
}