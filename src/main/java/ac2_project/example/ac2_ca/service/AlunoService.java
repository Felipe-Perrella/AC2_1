package ac2_project.example.ac2_ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2_project.example.ac2_ca.dto.*;
import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private  Aluno_repository alunoRepository;

    public Aluno createUser(AlunoDTO alunoDTO) {
    	Aluno user = new Aluno();
        user.setUsername(alunoDTO.getName());
        user.setEmail(new Aluno_Email(alunoDTO.getEmail()));
        return alunoRepository.save(user);
    }

    public  List<AlunoDTO> getAllUsers() {
        return alunoRepository.findAll().stream()
                .map(user -> {
                	AlunoDTO dto = new AlunoDTO();
                    dto.setName(user.getUsername());
                    dto.setEmail(user.getEmail().getEmailAddress());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}