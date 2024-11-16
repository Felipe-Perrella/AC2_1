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
@RequestMapping("/api/premios")
public class PremioController {

    @Autowired
    private PremioService premioService;

    @PostMapping
    public ResponseEntity<Premio> createPremio(@RequestBody PremioDTO premioDTO) {
    	Premio premio = premioService.createPremio(premioDTO);
        return new ResponseEntity<>(premio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PremioDTO>> getAllPremios() {
        List<PremioDTO> premios = premioService.getAllPremios();
        return new ResponseEntity<>(premios, HttpStatus.OK);
    }
}