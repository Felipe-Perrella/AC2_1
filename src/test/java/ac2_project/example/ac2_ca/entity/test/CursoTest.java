package ac2_project.example.ac2_ca.entity.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ac2_project.example.ac2_ca.entity.*;


public class CursoTest {
	
	 	@Test
	    void testCodCurso() {
	        Curso curso = new Curso();
	        Curso_Codigo codigo = new Curso_Codigo("ASYajsuuAj");
	        curso.setCodigo(codigo);
	        
	        assertEquals(codigo, curso.getCodigo());
	       
	    }
}
