package br.com.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import br.com.backend.model.Playlist;
import br.com.backend.model.Stem;
import br.com.backend.repository.PlaylistRepository;
import br.com.backend.repository.StemRepository;


// Serviço para lidar com a lógica de separação de faixas (stems) a partir de uma música
@Service
public class StemService {
    // Injeção do StemRepository para acessar o banco de dados
    @Autowired
    private StemRepository stemRepository;

    // Injeção do PlaylistRepository para acessar os dados da música
    @Autowired
    private PlaylistRepository playlistRepository;

    // Método assíncrono para processar a separação de faixas usando Spleeter
    @Async
    public void processarSeparacao(Long musicId) {
        Playlist musica = playlistRepository.findById(musicId)
            .orElseThrow(() -> new RuntimeException("Música não encontrada"));

        try {
            // Exemplo de comando chamando Spleeter (Python) via CLI
            // spleeter separate -o output/ /caminho/da/musica.mp3
            ProcessBuilder pb = new ProcessBuilder(
                "spleeter", "separate", 
                "-p", "spleeter:4stems", // Separa em 4 faixas
                "-o", "uploads/stems/", 
                musica.getCaminhoArquivo()
            );

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                salvarStemsNoBanco(musica);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para salvar os caminhos dos stems gerados no banco de dados
    private void salvarStemsNoBanco(Playlist musica) {
        // Lógica para varrer a pasta de saída e salvar os caminhos 
        // de Vocal, Bateria, Baixo e Outros no StemRepository
    }

    // Método para buscar os stems já gerados para uma música específica
    public List<Stem> buscarPorMusica(Long musicId) {
        return stemRepository.findByMusicaId(musicId);
    }
}