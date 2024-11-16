package ac2_project.example.ac2_ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac2_project.example.ac2_ca.dto.*;
import ac2_project.example.ac2_ca.entity.*;
import ac2_project.example.ac2_ca.service.*;




@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursosService;

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody CursoDTO cursoDTO) {
    	Curso curso = cursosService.createCurso(cursoDTO);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursos() {
        List<CursoDTO> cursos = cursosService.getAllCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
}