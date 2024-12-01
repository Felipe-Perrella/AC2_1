package ac2_project.example.ac2_ca.controller.test;



import ac2_project.example.ac2_ca.controller.PremioController;

import ac2_project.example.ac2_ca.dto.PremioDTO;
import ac2_project.example.ac2_ca.entity.Premio;
import ac2_project.example.ac2_ca.entity.Premio_Voucher;
import ac2_project.example.ac2_ca.service.*;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(PremioController.class) // Carrega apenas o contexto da camada web
public class PremioControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PremioService premioService;

    @Test
    void testCreatePremio() throws Exception {
        // Dados de entrada
        PremioDTO premioDTO = new PremioDTO();
        premioDTO.setVouchers(3);

        // Retorno simulado do serviço
        Premio premio = new Premio();
        Premio_Voucher voucher = new Premio_Voucher(3);
        premio.setId(1L);
        premio.setVouchers(voucher);
        when(premioService.createPremio(any(PremioDTO.class))).thenReturn(premio);

        // Realizar a requisição POST e verificar o resultado
        mockMvc.perform(post("/api/premios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(premioDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.qntVouchers").value(3));

        verify(premioService, times(1)).createPremio(any(PremioDTO.class));

    }
    
    @Test
    void testGetAllPremios() throws Exception {
        // Simula dados retornados pelo serviço
        PremioDTO premio1 = new PremioDTO();
        premio1.setVouchers(3);
        PremioDTO premio2 = new PremioDTO();
        premio2.setVouchers(5);
        List<PremioDTO> premios = Arrays.asList(premio1, premio2);

        when(premioService.getAllPremios()).thenReturn(premios);

        // Executa a requisição GET e verifica o resultado
        mockMvc.perform(get("/api/premios") // Atualize o endpoint se necessário
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(premios.size()))

                .andExpect(jsonPath("$[0].qntVouchers").value(3))

                .andExpect(jsonPath("$[1].qntVouchers").value(5));

        verify(premioService, times(1)).getAllPremios();
    }
    
    
}