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
@RequestMapping("/api/users")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> createUser(@RequestBody AlunoDTO alunoDTO) {
    	Aluno user = alunoService.createUser(alunoDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAllUsers() {
        List<AlunoDTO> users = alunoService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}