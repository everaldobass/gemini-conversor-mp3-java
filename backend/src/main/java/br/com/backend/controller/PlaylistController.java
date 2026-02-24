package br.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.model.Playlist;
import br.com.backend.service.PlaylistService;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    // Listar todas as músicas do usuário logado
    @GetMapping
    public ResponseEntity<List<Playlist>> listarMinhaPlaylist() {
        // Em uma implementação real, extraímos o ID do usuário do Token JWT
        Long usuarioLogadoId = 1L; // Exemplo estático para teste
        return ResponseEntity.ok(playlistService.listarPorUsuario(usuarioLogadoId));
    }

    // Buscar uma música específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> buscarPorId(@PathVariable Long id) {
        return playlistService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Excluir música da playlist
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMúsica(@PathVariable Long id) {
        playlistService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
