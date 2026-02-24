package br.com.backend.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import br.com.backend.model.Playlist;
import br.com.backend.model.User;
import br.com.backend.repository.PlaylistRepository;

// Serviço para lidar com a lógica de conversão de vídeos do YouTube para MP3
@Service
public class YoutubeService {

    // Injeção do PlaylistRepository para acessar os dados da música
    @Autowired
    private PlaylistRepository playlistRepository;


    // Método assíncrono para converter um vídeo do YouTube em MP3 usando yt-dlp
    @Async // Executa em thread separada para não travar a API
    public CompletableFuture<String> converterVideo(String videoUrl, User usuario) {
        String outputDir = "uploads/mp3/";
        String fileName = UUID.randomUUID().toString() + ".mp3";
        String fullPath = outputDir + fileName;

        try {
            // Comando para o yt-dlp: extrair áudio, formato mp3, qualidade máxima
            ProcessBuilder pb = new ProcessBuilder(
                "yt-dlp", 
                "-x", 
                "--audio-format", "mp3", 
                "-o", fullPath, 
                videoUrl
            );
            
            Process process = pb.start();
            int exitCode = process.waitFor();

            // Se a conversão foi bem-sucedida, salva os metadados no banco e retorna o caminho do arquivo
            if (exitCode == 0) {
                // Salva os metadados no banco após sucesso
                Playlist musica = new Playlist();
                musica.setTitulo("Download via YouTube"); // Opcional: extrair título real com yt-dlp --get-title
                musica.setCaminhoArquivo(fullPath);
                musica.setUsuario(usuario);
                playlistRepository.save(musica);
                
                return CompletableFuture.completedFuture("Conversão concluída: " + fileName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return CompletableFuture.failedFuture(new RuntimeException("Falha na conversão"));
    }
}
