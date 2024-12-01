package ac2_project.example.ac2_ca.service.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.repository.*;
import ac2_project.example.ac2_ca.service.*;

class AlunoServiceTest {

    @Mock
    private Aluno_repository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    
    @Test
    void testCreateAluno() {
        // Arrange
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setName("student01");
        alunoDTO.setEmail("student@example.com");

        Aluno savedAluno = new Aluno();
        savedAluno.setId(1L);
        savedAluno.setUsername("student01");
        savedAluno.setEmail(new Aluno_Email("student@example.com"));

        when(alunoRepository.save(any(Aluno.class))).thenReturn(savedAluno);

        // Act
        Aluno result = alunoService.createUser(alunoDTO);

        // Assert
        assertNotNull(result);
        assertEquals("student01", result.getUsername());
        assertEquals("student@example.com", result.getEmail().getEmailAddress());
        assertNotNull(result.getId());

        verify(alunoRepository, times(1)).save(any(Aluno.class));
    }

    @Test
    void testGetAllAlunos() {
        // Configurando dados fictícios
        Aluno aluno1 = new Aluno();
        aluno1.setUsername("aluno1");
        aluno1.setEmail(new Aluno_Email("aluno1@example.com"));
        aluno1.setSenha(new Aluno_Senha("aluno1Secret"));

        Aluno aluno2 = new Aluno();
        aluno2.setUsername("aluno2");
        aluno2.setEmail(new Aluno_Email("aluno2@example.com"));
        aluno2.setSenha(new Aluno_Senha("aluno2Secret"));

        // Mock do comportamento do repositório
        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));

        // Chamada ao método de serviço
        List<AlunoDTO> users = alunoService.getAllUsers();

        // Verificação dos resultados
        assertEquals(2, users.size());
        assertEquals("aluno1", users.get(0).getName());
        assertEquals("aluno1@example.com", users.get(0).getEmail());
    }
}