package ac2_project.example.ac2_ca.entity.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ac2_project.example.ac2_ca.entity.*;


public class CursoTest {
	
	@Test
    void testConstrutorComCodigoValido() {
        Curso_Codigo cursoCodigo = new Curso_Codigo("ABC");
        assertEquals("ABC", cursoCodigo.getCodigo());
    }

    @Test
    void testConstrutorComCodigoNulo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Curso_Codigo(null));
        assertEquals("Código inválido", exception.getMessage());
    }

    @Test
    void testConstrutorComCodigoComNumeros() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Curso_Codigo("A1B2"));
        assertEquals("Código inválido", exception.getMessage());
    }

    @Test
    void testConstrutorComCodigoComCaracteresEspeciais() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Curso_Codigo("AB@C"));
        assertEquals("Código inválido", exception.getMessage());
    }

    @Test
    void testGetCodigo() {
        Curso_Codigo cursoCodigo = new Curso_Codigo("XYZ");
        assertEquals("XYZ", cursoCodigo.getCodigo());
    }

    @Test
    void testEqualsComMesmoObjeto() {
        Curso_Codigo cursoCodigo = new Curso_Codigo("ABC");
        assertTrue(cursoCodigo.equals(cursoCodigo));
    }

    @Test
    void testEqualsComObjetosIguais() {
        Curso_Codigo cursoCodigo1 = new Curso_Codigo("DEF");
        Curso_Codigo cursoCodigo2 = new Curso_Codigo("DEF");
        assertTrue(cursoCodigo1.equals(cursoCodigo2));
        assertEquals(cursoCodigo1.hashCode(), cursoCodigo2.hashCode());
    }

    @Test
    void testEqualsComObjetosDiferentes() {
        Curso_Codigo cursoCodigo1 = new Curso_Codigo("GHI");
        Curso_Codigo cursoCodigo2 = new Curso_Codigo("JKL");
        assertFalse(cursoCodigo1.equals(cursoCodigo2));
    }

    @Test
    void testEqualsComObjetoNulo() {
        Curso_Codigo cursoCodigo = new Curso_Codigo("MNO");
        assertFalse(cursoCodigo.equals(null));
    }

    @Test
    void testEqualsComObjetoDeOutraClasse() {
        Curso_Codigo cursoCodigo = new Curso_Codigo("PQR");
        assertFalse(cursoCodigo.equals("Outro Objeto"));
    }
}
