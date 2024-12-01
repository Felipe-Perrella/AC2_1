package ac2_project.example.ac2_ca.controller.test;

import ac2_project.example.ac2_ca.controller.AlunoController;
import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.dto.PremioDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;
import ac2_project.example.ac2_ca.entity.Aluno_Senha;
import ac2_project.example.ac2_ca.entity.Premio;
import ac2_project.example.ac2_ca.entity.Premio_Voucher;
import ac2_project.example.ac2_ca.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class) // Carrega apenas o contexto da camada web
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService; // Injeta um mock do serviço, substituindo a necessidade do repositório
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void testCreateAluno() throws Exception {
        // Dados de entrada
    	 AlunoDTO mockAluno = new AlunoDTO();
    	 mockAluno.setName("JohnDoe");
         mockAluno.setEmail("john@example.com");
         mockAluno.setPassword("JohnDoeee");

        // Retorno simulado do serviço
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setUsername("JohnDoe");
        aluno.setEmail(new Aluno_Email("john@example.com"));
        aluno.setSenha(new Aluno_Senha("JohnDoeee"));
        
        
        when(alunoService.createUser(any(AlunoDTO.class))).thenReturn(aluno);

        // Realizar a requisição POST e verificar o resultado
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockAluno)))
        		.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("JohnDoe"))
                .andExpect(jsonPath("$.email.emailAddress").value("john@example.com"))
                .andExpect(jsonPath("$.senha").value("JohnDoeee"));

        verify(alunoService, times(1)).createUser(any(AlunoDTO.class));

    }
    

    @Test
    public void testGetAlunos() throws Exception {
        // Configura o comportamento do mock para o método de serviço
        AlunoDTO mockAluno = new AlunoDTO();
        mockAluno.setName("JohnDoe");
        mockAluno.setEmail("john@example.com");
        mockAluno.setPassword("JohnDoeee");
        
        List<AlunoDTO> mockAlunos = List.of(mockAluno);
        Mockito.when(alunoService.getAllUsers()).thenReturn(mockAlunos);

        // Realiza a requisição e verifica a resposta
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users") // Corrige o caminho da URL
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("JohnDoe")) // Primeiro objeto na lista
                .andExpect(jsonPath("$[0].email").value("john@example.com"))
                .andExpect(jsonPath("$[0].password").value("JohnDoeee"));
    }
    
}