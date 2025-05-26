package repository;
    
import java.util.Optional; // não encontrar um resultado

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // Marca esta interface como um componente de repositório Spring.
public interface Alunorepository extends JpaRepository<Aluno, Long> {
 
    Optional<Aluno> findByNome(String nome);

    com.example.EscolaAluno.model.Aluno saveAll(Aluno aluno);
}


