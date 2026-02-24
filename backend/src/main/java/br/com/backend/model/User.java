package br.com.backend.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// Entidade para representar os usuários do sistema
@Entity
@Table(name = "users")
@Data // Lombok para Getters/Setters
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha; // Armazenará o hash BCrypt

    private String nome;

    @Enumerated(EnumType.STRING)
    private Perfil perfil; // ADMIN ou USER

    private LocalDateTime dataCadastro = LocalDateTime.now();
}
