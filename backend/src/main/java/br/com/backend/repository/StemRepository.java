package br.com.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.backend.model.Stem;

@Repository
public interface StemRepository extends JpaRepository<Stem, Long> {
    // Busca todos os stems de uma música específica
    List<Stem> findByMusicaId(Long musicaId);
}
