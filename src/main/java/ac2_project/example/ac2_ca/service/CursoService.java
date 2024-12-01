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
public class CursoService {

    @Autowired
    private  Curso_repository cursoRepository;

    public Curso createCurso(CursoDTO cursoDTO) {
    	Curso curso = new Curso();
        curso.setCodigo(new Curso_Codigo(cursoDTO.getCodigo()));
        return cursoRepository.save(curso);
    }

    public  List<CursoDTO> getAllCursos() {
        return cursoRepository.findAll().stream()
                .map(curso -> {
                	CursoDTO dto = new CursoDTO();
                    dto.setCodigo(curso.getCodigo());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}