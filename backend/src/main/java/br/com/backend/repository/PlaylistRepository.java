package br.com.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.backend.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    
    // Busca todas as músicas de um usuário específico para a playlist privada
    List<Playlist> findByUsuarioIdOrderByDataUploadDesc(Long usuarioId);
    
    // Caso queira buscar por título (busca simples)
    List<Playlist> findByTituloContainingIgnoreCase(String titulo);
}
