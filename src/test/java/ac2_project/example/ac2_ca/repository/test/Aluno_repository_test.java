package ac2_project.example.ac2_ca.repository.test;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.repository.*;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertNotNull;
@ActiveProfiles("test")
@DataJpaTest
public class Aluno_repository_test {
	  @Autowired
	    private Aluno_repository alunoRepository;


	    @Test
	    public void testSaveAndFindAluno() {
	        // Cria um novo Aluno
	        Aluno user = new Aluno();
	        user.setUsername("Henrique");;


	        // Salva no banco de dados
	        Aluno savedUser = alunoRepository.save(user);
	        assertNotNull(savedUser.getId());
	        // Busca o usuário pelo ID
	        Optional<Aluno> retrievedUser = alunoRepository.findById(savedUser.getId());
	        assertThat(retrievedUser).isPresent();
	        assertThat(retrievedUser.get().getUsername()).isEqualTo("Henrique");
	    }
	

}
