package ac2_project.example.ac2_ca.service.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import ac2_project.example.ac2_ca.dto.CursoDTO;
import ac2_project.example.ac2_ca.dto.PremioDTO;
import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.repository.*;
import ac2_project.example.ac2_ca.service.*;

class CursoServiceTest {

    @Mock
    private Curso_repository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCursos() {
        // Configurando dados fictícios
        Curso curso1 = new Curso();
        curso1.setCodigo(new Curso_Codigo("testecodIGo"));;

        Curso curso2 = new Curso();
        curso2.setCodigo(new Curso_Codigo("tesTEEEcodIGo"));;

        // Mock do comportamento do repositórioc
        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));

        // Chamada ao método de serviço
        List<CursoDTO> cursos = cursoService.getAllCursos();

        // Verificação dos resultados
        assertEquals(2, cursos.size());
        assertEquals("testecodIGo", cursos.get(0).getCodigo());
        assertEquals("tesTEEEcodIGo", cursos.get(1).getCodigo());
    }
}