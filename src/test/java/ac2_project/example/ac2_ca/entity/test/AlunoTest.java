package ac2_project.example.ac2_ca.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;



import ac2_project.example.ac2_ca.entity.*;

public class AlunoTest {	
	@Test
    void testSetAndGetId() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        assertEquals(1L, aluno.getId());
    }

    @Test
    void testSetAndGetUsername() {
        Aluno aluno = new Aluno();
        aluno.setUsername("student01");
        assertEquals("student01", aluno.getUsername());
    }

    @Test
    void testSetAndGetEmail() {
        Aluno aluno = new Aluno();
        Aluno_Email email = new Aluno_Email("student@example.com");
        aluno.setEmail(email);
        assertEquals(email, aluno.getEmail());
        assertEquals("student@example.com", aluno.getEmail().getEmailAddress());
    }

    @Test
    void testSetAndGetSenha() {
        Aluno aluno = new Aluno();
        Aluno_Senha senha = new Aluno_Senha("strongPassword123");
        aluno.setSenha(senha);
      
        assertEquals("strongPassword123", aluno.getSenha());
    }

    @Test
    void testDefaultIdIsNull() {
        Aluno aluno = new Aluno();
        assertNull(aluno.getId());
    }


    @Test
    void testEqualsAndHashCodeWithSameObject() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setUsername("student01");
        Aluno_Email email = new Aluno_Email("student@example.com");
        aluno.setEmail(email);
        Aluno_Senha senha = new Aluno_Senha("strongPassword123");
        aluno.setSenha(senha);

        assertEquals(aluno, aluno);
        assertEquals(aluno.hashCode(), aluno.hashCode());
    }

    @Test
    void testEqualsAndHashCodeWithDifferentObjects() {
        Aluno aluno1 = new Aluno();
        aluno1.setId(1L);
        aluno1.setUsername("student01");
        Aluno_Email email1 = new Aluno_Email("student@example.com");
        aluno1.setEmail(email1);
        Aluno_Senha senha1 = new Aluno_Senha("strongPassword123");
        aluno1.setSenha(senha1);

        Aluno aluno2 = new Aluno();
        aluno2.setId(2L);
        aluno2.setUsername("student02");
        Aluno_Email email2 = new Aluno_Email("student2@example.com");
        aluno2.setEmail(email2);
        Aluno_Senha senha2 = new Aluno_Senha("anotherPassword456");
        aluno2.setSenha(senha2);

        assertNotEquals(aluno1, aluno2);
        assertNotEquals(aluno1.hashCode(), aluno2.hashCode());
    }
}
