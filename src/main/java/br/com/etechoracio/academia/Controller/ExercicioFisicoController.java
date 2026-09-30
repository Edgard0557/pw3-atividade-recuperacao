package br.com.etechoracio.academia.Controller;

import br.com.etechoracio.academia.DTO.ExercicoFisicoResponseDTO;
import br.com.etechoracio.academia.Service.ExercicioFisicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    private final ExercicioFisicoService service;

    public ExercicioFisicoController(
            ExercicioFisicoService service) {

        this.service = service;
    }

    @GetMapping
    public List<ExercicoFisicoResponseDTO> listar() {
        return service.listarAprovados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicoFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        var exercicio = service.buscarPorId(id);
        if(exercicio == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(exercicio);
    }
}