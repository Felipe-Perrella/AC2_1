package ac2_project.example.ac2_ca.entity.test;

import org.junit.jupiter.api.Test;
import ac2_project.example.ac2_ca.entity.*;

import static org.junit.jupiter.api.Assertions.*;

class AlunoSenhaTest {

    @Test
    void testValidPasswordCreation() {
        Aluno_Senha alunoSenha = new Aluno_Senha("password123");
        assertNotNull(alunoSenha);
        assertEquals("password123", alunoSenha.getPassword());
    }

    @Test
    void testInvalidPasswordNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno_Senha(null));
        assertEquals("Senha inválida", exception.getMessage());
    }

    @Test
    void testInvalidPasswordShortLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno_Senha("short"));
        assertEquals("Senha inválida", exception.getMessage());
    }

    @Test
    void testEqualsSameObject() {
        Aluno_Senha alunoSenha = new Aluno_Senha("password123");
        assertTrue(alunoSenha.equals(alunoSenha)); // Reflexividade
    }

    @Test
    void testEqualsDifferentObjectsWithSamePassword() {
        Aluno_Senha alunoSenha1 = new Aluno_Senha("password123");
        Aluno_Senha alunoSenha2 = new Aluno_Senha("password123");
        assertTrue(alunoSenha1.equals(alunoSenha2));
    }

    @Test
    void testEqualsDifferentObjectsWithDifferentPasswords() {
        Aluno_Senha alunoSenha1 = new Aluno_Senha("password123");
        Aluno_Senha alunoSenha2 = new Aluno_Senha("different123");
        assertFalse(alunoSenha1.equals(alunoSenha2));
    }

    @Test
    void testEqualsNull() {
        Aluno_Senha alunoSenha = new Aluno_Senha("password123");
        assertFalse(alunoSenha.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        Aluno_Senha alunoSenha = new Aluno_Senha("password123");
        assertFalse(alunoSenha.equals("password123")); // Comparação com uma String
    }

    @Test
    void testHashCodeForEqualObjects() {
        Aluno_Senha alunoSenha1 = new Aluno_Senha("password123");
        Aluno_Senha alunoSenha2 = new Aluno_Senha("password123");
        assertEquals(alunoSenha1.hashCode(), alunoSenha2.hashCode());
    }

    @Test
    void testHashCodeForDifferentObjects() {
        Aluno_Senha alunoSenha1 = new Aluno_Senha("password123");
        Aluno_Senha alunoSenha2 = new Aluno_Senha("different123");
        assertNotEquals(alunoSenha1.hashCode(), alunoSenha2.hashCode());
    }
}