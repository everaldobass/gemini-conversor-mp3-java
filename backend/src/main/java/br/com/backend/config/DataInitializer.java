package br.com.backend.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.backend.model.Perfil;
import br.com.backend.model.User;
import br.com.backend.repository.UserRepository;


// Classe de configuração para inicializar dados no banco de dados
@Configuration
public class DataInitializer {

    // Método que será executado na inicialização da aplicação para criar um usuário ADMIN
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            // Verifica se o admin já existe para não duplicar a cada reinicialização
            if (userRepository.findByEmail("admin").isEmpty()) {
                User admin = new User();
                admin.setNome("Administrador");
                admin.setEmail("admin@gmail.com");
                // Criptografa a senha "admin" antes de salvar
                admin.setSenha(passwordEncoder.encode("admin"));
                admin.setPerfil(Perfil.ADMIN);
                admin.setDataCadastro(LocalDateTime.now());

                userRepository.save(admin);
                System.out.println("✅ Usuário ADMIN criado com sucesso!");
                System.out.println("Login: admin");
                System.out.println("Senha: admin");
            }
        };
    }
}
