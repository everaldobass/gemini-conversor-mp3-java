package br.com.backend.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.dto.YoutubeRequestDTO;
import br.com.backend.service.YoutubeService;

@RestController
@RequestMapping("/api/youtube")
public class YoutubeController {

    @Autowired
    private YoutubeService youtubeService;

    @PostMapping("/convert")
    public ResponseEntity<String> convert(@RequestBody YoutubeRequestDTO dto, Principal principal) {
        // O 'principal' contém o usuário logado via JWT
        // Aqui você buscaria o User no banco pelo nome do principal
        
        youtubeService.converterVideo(dto.url(), null); // Passar o User autenticado aqui
        return ResponseEntity.accepted().body("Conversão iniciada em segundo plano...");
    }
}
