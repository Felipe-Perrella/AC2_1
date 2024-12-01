package ac2_project.example.ac2_ca.repository.test;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.repository.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ActiveProfiles("test")
@DataJpaTest
public class Premio_repository_test {
	  @Autowired
	    private Premio_repository premioRepository;


	    @Test
	    public void testSaveAndFindPremio() {
	        Premio premio = new Premio();
	        premio.setVouchers(new Premio_Voucher(2));;


	        // Salva no banco de dados
	        Premio savedPremio = premioRepository.save(premio);
	        assertNotNull(savedPremio.getId());

	        Optional<Premio> retrievedPremio = premioRepository.findById(savedPremio.getId());
	        assertThat(retrievedPremio).isPresent();
	        assertEquals(2,retrievedPremio.get().getVoucher().getQtdVoucher());
	    }
	

}
