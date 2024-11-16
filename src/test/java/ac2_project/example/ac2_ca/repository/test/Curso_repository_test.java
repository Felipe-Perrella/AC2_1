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
public class Curso_repository_test {
	  @Autowired
	    private Curso_repository cursoRepository;


	    @Test
	    public void testSaveAndFindCurso() {
	   
	        Curso curso = new Curso();
	        curso.setCodigo(new Curso_Codigo("ahsuHSeCX"));;


	        // Salva no banco de dados
	        Curso savedCurso = cursoRepository.save(curso);
	        assertNotNull(savedCurso.getId());

	        Optional<Curso> retrievedCurso = cursoRepository.findById(savedCurso.getId());
	        assertThat(retrievedCurso).isPresent();
	        assertThat(retrievedCurso.get().getCodigo()).isEqualTo("ahsuHSeCX");
	    }
	

}
