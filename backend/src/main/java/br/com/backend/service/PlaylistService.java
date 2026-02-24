package br.com.backend.service;

import java.io.File;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.backend.model.Playlist;
import br.com.backend.repository.PlaylistRepository;
import jakarta.transaction.Transactional;

// Serviço para lidar com operações relacionadas à playlist do usuário
@Service
public class PlaylistService {

    // Injeção do PlaylistRepository para acessar o banco de dados
    @Autowired
    private PlaylistRepository playlistRepository;

    // Listar todas as músicas do usuário logado, ordenadas por data de upload
    public List<Playlist> listarPorUsuario(Long usuarioId) {
        return playlistRepository.findByUsuarioIdOrderByDataUploadDesc(usuarioId);
    }

    // Buscar uma música específica por ID
    public Optional<Playlist> buscarPorId(Long id) {
        return playlistRepository.findById(id);
    }

    // Excluir música da playlist, removendo o arquivo físico e o registro do banco
    @Transactional
    public void excluir(Long id) {
        playlistRepository.findById(id).ifPresent(musica -> {
            // 1. Lógica para deletar o arquivo físico do HD
            File arquivo = new File(musica.getCaminhoArquivo());
            if (arquivo.exists()) {
                arquivo.delete();
            }
            // 2. Deletar registro do banco
            playlistRepository.delete(musica);
        });
    }
}
