package br.com.backend.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// Entidade para representar as músicas convertidas e adicionadas à playlist do usuário
@Entity
@Table(name = "playlist")
@Data
@Getter
@Setter
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String artista;
    private String caminhoArquivo; // Localização do MP3 no servidor
    private LocalDateTime dataUpload = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario; // Relaciona a música ao usuário que converteu
}
