package ac2_project.example.ac2_ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2_project.example.ac2_ca.dto.*;
import ac2_project.example.ac2_ca.entity.Curso_Codigo;
import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PremioService {

    @Autowired
    private  Premio_repository premioRepository;

    public Premio createPremio(PremioDTO premioDTO) {
    	Premio premio = new Premio();
    	premio.setVouchers(new Premio_Voucher(premioDTO.getQntVouchers()));
        return premioRepository.save(premio);
    }

    public  List<PremioDTO> getAllPremios() {
        return premioRepository.findAll().stream()
                .map(premio -> {
                	PremioDTO dto = new PremioDTO();
                    dto.setVouchers(premio.getQntVouchers());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}