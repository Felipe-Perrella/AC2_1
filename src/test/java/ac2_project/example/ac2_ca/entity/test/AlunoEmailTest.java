import org.junit.jupiter.api.Test;

import ac2_project.example.ac2_ca.entity.Aluno_Email;

import static org.junit.jupiter.api.Assertions.*;

class AlunoEmailTest {

    @Test
    void testValidEmailCreation() {
        Aluno_Email alunoEmail = new Aluno_Email("test@example.com");
        assertNotNull(alunoEmail);
        assertEquals("test@example.com", alunoEmail.getEmailAddress());
    }

    @Test
    void testInvalidEmailNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno_Email(null));
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormatNoAtSymbol() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno_Email("invalidemail.com"));
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormatNoDomain() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno_Email("invalid@"));
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormatSpecialCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno_Email("invalid@!domain.com"));
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void testEqualsSameObject() {
        Aluno_Email alunoEmail = new Aluno_Email("test@example.com");
        assertTrue(alunoEmail.equals(alunoEmail)); // Reflexividade
    }

    @Test
    void testEqualsDifferentObjectsWithSameEmail() {
        Aluno_Email alunoEmail1 = new Aluno_Email("test@example.com");
        Aluno_Email alunoEmail2 = new Aluno_Email("test@example.com");
        assertTrue(alunoEmail1.equals(alunoEmail2));
    }

    @Test
    void testEqualsDifferentObjectsWithDifferentEmails() {
        Aluno_Email alunoEmail1 = new Aluno_Email("test@example.com");
        Aluno_Email alunoEmail2 = new Aluno_Email("different@example.com");
        assertFalse(alunoEmail1.equals(alunoEmail2));
    }

    @Test
    void testEqualsNull() {
        Aluno_Email alunoEmail = new Aluno_Email("test@example.com");
        assertFalse(alunoEmail.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        Aluno_Email alunoEmail = new Aluno_Email("test@example.com");
        assertFalse(alunoEmail.equals("test@example.com")); // Comparação com uma String
    }

    @Test
    void testHashCodeForEqualObjects() {
        Aluno_Email alunoEmail1 = new Aluno_Email("test@example.com");
        Aluno_Email alunoEmail2 = new Aluno_Email("test@example.com");
        assertEquals(alunoEmail1.hashCode(), alunoEmail2.hashCode());
    }

    @Test
    void testHashCodeForDifferentObjects() {
        Aluno_Email alunoEmail1 = new Aluno_Email("test@example.com");
        Aluno_Email alunoEmail2 = new Aluno_Email("different@example.com");
        assertNotEquals(alunoEmail1.hashCode(), alunoEmail2.hashCode());
    }
}
