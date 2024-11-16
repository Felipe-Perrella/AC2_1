package ac2_project.example.ac2_ca.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;



import ac2_project.example.ac2_ca.entity.*;

public class AlunoTest {	
	 	@Test
	    void testSetAndGetValidEmail() {
	        Aluno user = new Aluno();
	        Aluno_Email email = new Aluno_Email("test@example.com");
	        user.setEmail(email);
	        
	        assertEquals(email, user.getEmail());
	    }

	    @Test
	    void testInvalidEmailThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Aluno_Email("Email inválido");
	        });
	    }
	    
	    @Test
	    void testSetAndGetValidPassword() {
	        Aluno user = new Aluno();
	        Aluno_Senha senha = new Aluno_Senha("Senha_de_Teste");
	        user.setSenha(senha);
	        
	        assertEquals(senha, user.getSenha());
	    }
	    
	    @Test
	    void testInvalidPasswordThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Aluno_Email("Senha inválida");
	        });
	    }
}
