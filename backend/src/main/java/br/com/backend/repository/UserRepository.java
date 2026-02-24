package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Método para buscar usuário durante o login
    java.util.Optional<User> findByEmail(String email);
}