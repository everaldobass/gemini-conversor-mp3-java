package br.com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.backend.dto.RegisterDTO;
import br.com.backend.model.Perfil;
import br.com.backend.model.User;
import br.com.backend.repository.UserRepository;


// Serviço para lidar com autenticação e cadastro de usuários
@Service
public class AuthService {
    // Injeção do UserRepository para acessar o banco de dados
    @Autowired
    private UserRepository userRepository;
    
    // Injeção do BCryptPasswordEncoder para criptografar senhas
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Método para cadastrar um novo usuário
    public User cadastrar(RegisterDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(passwordEncoder.encode(dto.senha())); // Criptografia
        user.setPerfil(Perfil.USER);
        return userRepository.save(user);
    }
}
