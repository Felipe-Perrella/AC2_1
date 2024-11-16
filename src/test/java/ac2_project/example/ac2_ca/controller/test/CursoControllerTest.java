package ac2_project.example.ac2_ca.controller.test;


import ac2_project.example.ac2_ca.controller.CursoController;
import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.dto.CursoDTO;
import ac2_project.example.ac2_ca.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CursoController.class) // Carrega apenas o contexto da camada web
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoService cursoService; // Injeta um mock do serviço, substituindo a necessidade do repositório

    @Test
    public void testGetCursos() throws Exception {
        // Configura o comportamento do mock para o método de serviço
    	CursoDTO mockCurso = new CursoDTO();
    	mockCurso.setCodigo("CodigoTeste");

        
        List<CursoDTO> mockCursos= List.of(mockCurso);
        Mockito.when(cursoService.getAllCursos()).thenReturn(mockCursos);

        // Realiza a requisição e verifica a resposta
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cursos") // Corrige o caminho da URL
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].codigo").value("CodigoTeste")); // Primeiro objeto na lista 
    }
}