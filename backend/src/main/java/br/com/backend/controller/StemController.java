package br.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.backend.model.Stem;
import br.com.backend.service.StemService;

// Controlador para lidar com as requisições relacionadas à separação de faixas (stems)
@RestController
@RequestMapping("/api/stems")
public class StemController {

    // Injeção do StemService para acessar a lógica de separação de faixas
    @Autowired
    private StemService stemService;

    // Inicia o processo de separação para uma música específica
    @PostMapping("/{musicId}")
    public ResponseEntity<String> separarFaixas(@PathVariable Long musicId) {
        stemService.processarSeparacao(musicId);
        return ResponseEntity.accepted().body("Processamento de stems iniciado...");
    }

    // Lista os stems já gerados para uma música
    @GetMapping("/{musicId}")
    public ResponseEntity<List<Stem>> listarStems(@PathVariable Long musicId) {
        return ResponseEntity.ok(stemService.buscarPorMusica(musicId));
    }
}