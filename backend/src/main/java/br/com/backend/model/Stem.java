package br.com.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

// Entidade para representar os "pedaços" (stems) gerados a partir da separação de uma música
@Entity
@Table(name = "stems")
@Data
public class Stem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musica_id")
    private Playlist musica; // A qual música este "pedaço" pertence

    @Enumerated(EnumType.STRING)
    private TipoStem tipo; // VOCAL, BATERIA, BAIXO, OUTRO

    private String caminhoArquivo;
}