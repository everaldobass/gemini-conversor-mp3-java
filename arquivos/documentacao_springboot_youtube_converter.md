# 📌 Documentação do Sistema -- Conversor de YouTube para MP3 com Playlist (Spring Boot + SPA)

------------------------------------------------------------------------

# 1️⃣ Visão Geral do Sistema

O sistema permitirá que usuários autenticados: - Inserir link de vídeo
do YouTube - Converter vídeo para MP3 - Armazenar músicas no banco de
dados - Gerenciar playlist - Reproduzir músicas via player web -
Realizar separação de faixas (stems)

## 🏗 Arquitetura

-   Backend: Spring Boot (REST API)
-   Frontend: ReactJS, VueJS ou Angular (SPA)
-   Banco de Dados: SQLite3 (dev) ou MongoDB / PostgreSQL (produção)
-   Autenticação: JWT
-   Comunicação: HTTP/HTTPS (JSON)

Arquitetura desacoplada (API + SPA).

------------------------------------------------------------------------

# 2️⃣ Arquitetura Backend -- Spring Boot

## 📁 Estrutura de Pastas
    src/main/java/com/seuprojeto/youtubeconverter
    │
    ├── config/
    │   └── SecurityConfig.java
    │
    ├── controller/
    │   ├── AuthController.java
    │   ├── YoutubeController.java
    │   ├── PlaylistController.java
    │   └── StemController.java
    │
    ├── service/
    │   ├── AuthService.java
    │   ├── YoutubeService.java
    │   ├── PlaylistService.java
    │   └── StemService.java
    │
    ├── repository/
    │   ├── UserRepository.java
    │   ├── PlaylistRepository.java
    │   └── StemRepository.java
    │
    ├── model/
    │   ├── User.java
    │   ├── Playlist.java
    │   └── Stem.java
    │
    ├── dto/
    │   ├── LoginDTO.java
    │   ├── RegisterDTO.java
    │   └── MusicDTO.java
    │
    └── YoutubeConverterApplication.java

------------------------------------------------------------------------

# 3️⃣ Requisitos Funcionais

## 🔐 Autenticação

Funcionalidades: - Cadastro de usuário - Login com JWT - Controle de
acesso por perfil (ADMIN / USER) - Senha criptografada com BCrypt

### Entidade: User (Tabela: users)

  Campo          Tipo
  -------------- --------------------
  id             Long
  nome           String
  email          String (unique)
  senha          String (hash)
  perfil         Enum (ADMIN, USER)
  dataCadastro   LocalDateTime

------------------------------------------------------------------------

## 🎧 Playlist (Banco de Músicas)

Tabela: playlist

  Campo            Tipo
  ---------------- ---------------
  id               Long
  titulo           String
  artista          String
  genero           String
  bpm              Integer
  tom              String
  duracao          String
  caminhoArquivo   String
  dataUpload       LocalDateTime
  usuarioId        FK User

Funcionalidades: - Listar músicas do usuário - Reproduzir música -
Excluir música - Paginação da playlist - Upload automático após
conversão

------------------------------------------------------------------------

# 4️⃣ Separação de Faixas (Stem Separation)

Separação de áudio em: - Vocais - Bateria - Baixo - Outros

Integração recomendada (microserviço Python): - Spleeter - Demucs

Tabela: stems

  Campo            Tipo
  ---------------- -------------------------------------
  id               Long
  musicaId         FK Playlist
  tipo             Enum (VOCAL, BATERIA, BAIXO, OUTRO)
  caminhoArquivo   String

------------------------------------------------------------------------

# 5️⃣ Fluxo do Sistema

## 🔄 Fluxo de Login

1.  Usuário acessa o frontend (React/Vue/Angular)
2.  Envia credenciais para /api/auth/login
3.  Backend valida usuário
4.  Retorna token JWT
5.  Frontend armazena token (LocalStorage ou Cookie)
6.  Requisições autenticadas via Authorization: Bearer TOKEN

------------------------------------------------------------------------

## 🎥 Conversão YouTube → MP3

1.  Usuário cola o link do YouTube
2.  Frontend envia POST /api/youtube/convert
3.  Backend executa conversão com yt-dlp
4.  Áudio convertido para MP3
5.  Arquivo salvo em /uploads/mp3/
6.  Dados persistidos no banco
7.  Música aparece na playlist

Processamento recomendado: - Assíncrono com @Async - Ou fila
(RabbitMQ/Redis)

------------------------------------------------------------------------

# 6️⃣ API REST Endpoints

## 🔐 Autenticação

    POST   /api/auth/register
    POST   /api/auth/login

Body Register:

``` json
{
  "nome": "string",
  "email": "string",
  "senha": "string"
}
```

------------------------------------------------------------------------

## 🎵 Playlist

    GET    /api/playlist
    GET    /api/playlist/{id}
    DELETE /api/playlist/{id}

------------------------------------------------------------------------

## 🎥 Conversão

    POST /api/youtube/convert

Body:

``` json
{
  "url": "https://youtube.com/..."
}
```

------------------------------------------------------------------------

## 🎚 Stems

    POST /api/stems/{musicId}
    GET  /api/stems/{musicId}

------------------------------------------------------------------------

# 7️⃣ Frontend (React, Vue ou Angular)

SPA consumindo API REST via Axios ou Fetch.

## Telas do Sistema

### 📄 Login

-   Email
-   Senha

### 📄 Cadastro

-   Nome
-   Email
-   Senha

### 📄 Dashboard

Componentes: - Input para link do YouTube - Botão Converter - Lista de
músicas (Playlist) - Player de áudio HTML5

------------------------------------------------------------------------

# 8️⃣ Player de Música

Funcionalidades: - Play / Pause - Próxima música - Música anterior -
Controle de volume - Auto play ao clicar na faixa - Barra de progresso

Bibliotecas recomendadas: - HTML5 Audio API - WaveSurfer.js - Howler.js

------------------------------------------------------------------------

# 9️⃣ Segurança

-   Spring Security
-   JWT Authentication
-   BCrypt para hash de senha
-   CORS configurado para SPA
-   Validação de DTO
-   Rate Limiting (anti-abuso)

------------------------------------------------------------------------

# 🔟 Requisitos Não Funcionais

-   Conversão assíncrona
-   Logs de conversão
-   Tratamento global de exceções (@ControllerAdvice)
-   Arquitetura em camadas (Controller, Service, Repository)
-   Paginação e performance
-   Escalável para microsserviços

------------------------------------------------------------------------

# 1️⃣1️⃣ Tecnologias Recomendadas

Backend: - Java 17+ - Spring Boot - Spring Security - Spring Data JPA -
Hibernate - Lombok - JWT

Banco de Dados: - SQLite (Desenvolvimento) - MongoDB (NoSQL opcional) -
PostgreSQL (Produção)

Frontend: - ReactJS ou VueJS ou Angular - Axios - TailwindCSS ou
Bootstrap

------------------------------------------------------------------------

# 📌 Melhorias Futuras

-   Sistema de favoritos
-   Upload manual de MP3
-   Waveform visual (WaveSurfer)
-   Permissões por perfil (RBAC)
-   Deploy com Docker
-   Integração com AWS S3 ou Cloud Storage
-   Microserviço de processamento de áudio
-   Fila com RabbitMQ ou Kafka

------------------------------------------------------------------------

# 🧠 Observação Técnica

A separação de faixas (stems) exige alto processamento computacional.

Recomendações: - Servidor com GPU - Processamento em fila - Microserviço
dedicado em Python - Armazenamento em storage escalável (S3 ou
equivalente)

------------------------------------------------------------------------

✅ Documento técnico preparado para arquitetura moderna com Spring
Boot + Frontend SPA (React, Vue ou Angular).
