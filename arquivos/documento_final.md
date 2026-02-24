🎵 YouTube Converter API - Documentação do Backend
- Este documento detalha a arquitetura, endpoints e funcionamento do backend construído com Spring Boot 3.x.
🚀 Tecnologias UtilizadasJava 17Spring Boot (Web, Data JPA, Security, Validation)Lombok (Produtividade)yt-dlp (Conversão de vídeo)SQLite / PostgreSQL (Banco de dados)JWT (Autenticação Stateless)

📂 Estrutura de Pastas 
```
Plaintext
src/main/java/com/projeto/converter
├── config/       # Configurações de Segurança, CORS e Async
├── controller/   # Endpoints REST (Auth, Youtube, Playlist, Stems)
├── dto/          # Objetos de transferência de dados (Request/Response)
├── exception/    # Tratamento global de erros (@ControllerAdvice)
├── model/        # Entidades do banco de dados (JPA)
├── repository/   # Interfaces de comunicação com o banco
└── service/      # Lógica de negócio e integrações (ProcessBuilder)
```


🔐 Endpoints de Autenticação
```
Base URL: /api/auth
Método     Endpoint    Descrição                  Autenticação
POST      /register    Cadastra novo usuário      Pública
POST      /login       Login e geração de JWT     Pública
```

🎥 Endpoints de Conversão e Playlist
```
Base URL: /api

Método        Endpoint                   Descrição                             Autenticação
POST          /youtube/convert           Inicia conversão (Async) via URL      JWT Requerido
GET           /playlist                  Lista músicas do usuário logado       JWT Requerido
GET           /playlist/{id}             Detalhes de uma música específica     JWT Requerido
DELETE        /playlist/{id}             Exclui música e arquivo físico        JWT Requerido
POST          /stems/{musicId}           Inicia separação de faixas (Spleeter) JWT Requerido
```


⚙️ Processamento de Áudio
```
- O sistema utiliza processos assíncronos para não bloquear a experiência do usuário:
1 - Conversão: O Spring chama o yt-dlp em uma thread separada (@Async).
2 - Armazenamento: Os arquivos são salvos localmente em uploads/mp3/.
3 - Streaming: O backend serve os arquivos como recursos estáticos via /uploads/**.
```

🛠️ Requisitos de AmbientePara o backend funcionar corretamente, o servidor de hospedagem deve possuir:
```
1 - FFmpeg instalado e no PATH do sistema.
2 - yt-dlp instalado.
3 - Python + Spleeter (caso deseje habilitar a separação de faixas).
```