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

import ac2_project.example.ac2_ca.dto.PremioDTO;
import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.repository.*;
import ac2_project.example.ac2_ca.service.*;

class PremioServiceTest {

    @Mock
    private Premio_repository premioRepository;

    @InjectMocks
    private PremioService premioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPremios() {
        // Configurando dados fictícios
        Premio premio1 = new Premio();
        premio1.setVouchers(new Premio_Voucher(1));

        Premio premio2 = new Premio();
        premio2.setVouchers(new Premio_Voucher(4));

        // Mock do comportamento do repositório
        when(premioRepository.findAll()).thenReturn(Arrays.asList(premio1, premio2));

        // Chamada ao método de serviço
        List<PremioDTO> premios = premioService.getAllPremios();

        // Verificação dos resultados
        assertEquals(2, premios.size());
        assertEquals(1, premios.get(0).getQntVouchers());
        assertEquals(4, premios.get(1).getQntVouchers());
    }
}