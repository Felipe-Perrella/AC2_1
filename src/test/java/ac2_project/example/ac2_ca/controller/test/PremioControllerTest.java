package ac2_project.example.ac2_ca.controller.test;



import ac2_project.example.ac2_ca.controller.PremioController;
import ac2_project.example.ac2_ca.dto.CursoDTO;
import ac2_project.example.ac2_ca.dto.PremioDTO;
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

@WebMvcTest(PremioController.class) // Carrega apenas o contexto da camada web
public class PremioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PremioService premioervice; // Injeta um mock do serviço, substituindo a necessidade do repositório

    @Test
    public void testGetCursos() throws Exception {
        // Configura o comportamento do mock para o método de serviço
    	PremioDTO mockPremio = new PremioDTO();
    	mockPremio.setVouchers(5);

        
        List<PremioDTO> mockPremios= List.of(mockPremio);
        Mockito.when(premioervice.getAllPremios()).thenReturn(mockPremios);

        // Realiza a requisição e verifica a resposta
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premios") // Corrige o caminho da URL
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].qntVouchers").value(5)); // Primeiro objeto na lista   
    }
}