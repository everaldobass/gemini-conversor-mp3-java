# 📌 Documentação do Backend -- Conversor YouTube para MP3

Este documento detalha a implementação da API REST desenvolvida em
Spring Boot, focada na conversão de vídeos, gerenciamento de playlists e
separação de faixas (stems).

------------------------------------------------------------------------

## 🏗️ 1. Arquitetura do Sistema

O sistema segue o padrão de arquitetura em camadas para garantir
escalabilidade e fácil manutenção:

-   **Controller:** Expõe os endpoints REST e lida com requisições HTTP.
-   **Service:** Contém a lógica de negócio e integrações externas
    (yt-dlp/Spleeter).
-   **Repository:** Interface de comunicação com o banco de dados via
    Spring Data JPA.
-   **Model:** Entidades JPA que representam as tabelas do banco de
    dados.
-   **DTO:** Objetos de transferência para segurança e validação de
    dados.

------------------------------------------------------------------------

## 📂 2. Estrutura de Pastas

``` plaintext
src/main/java/com/projeto/youtubeconverter
├── config/             # Segurança (JWT), CORS, Async e Recursos Estáticos
├── controller/         # AuthController, YoutubeController, PlaylistController, StemController
├── service/            # Lógica de conversão, gerenciamento e IA de áudio
├── repository/         # Interfaces para User, Playlist e Stem
├── model/              # Entidades User, Playlist, Stem e Enums
├── dto/                # LoginDTO, RegisterDTO, MusicDTO, YoutubeRequestDTO
└── exception/          # GlobalExceptionHandler para erros amigáveis
```

------------------------------------------------------------------------

## 🔐 3. Segurança e Autenticação

A API utiliza Spring Security com JWT (JSON Web Token):

-   **Criptografia:** Senhas são armazenadas utilizando o algoritmo
    BCrypt.

-   **Acesso:** Rotas de `/api/auth/**` são públicas; demais rotas
    exigem o header:

    Authorization: Bearer {token}

-   **Sessão:** Stateless (sem estado no servidor).

------------------------------------------------------------------------

## 🎵 4. Fluxos de Processamento

### 🎥 Conversão YouTube → MP3

1.  O usuário envia uma URL via `POST /api/youtube/convert`.
2.  O sistema utiliza a anotação `@Async` para processar a conversão em
    segundo plano.
3.  O comando `yt-dlp` é executado via `ProcessBuilder` para extrair o
    áudio.
4.  O arquivo é salvo em `uploads/mp3/` e os metadados no banco de
    dados.

### 🎚️ Separação de Stems (IA)

-   Inicia via `POST /api/stems/{musicId}`.
-   Utiliza ferramentas como Spleeter ou Demucs para isolar:
    -   Vocais
    -   Bateria
    -   Baixo
    -   Outros
-   Gera arquivos independentes vinculados à música original na tabela
    `stems`.

------------------------------------------------------------------------

## 📡 5. Principais Endpoints (API REST)

  -----------------------------------------------------------------------------
  Categoria           Método         Endpoint               Descrição
  ------------------- -------------- ---------------------- -------------------
  Auth                POST           /api/auth/register     Cadastro de novos
                                                            usuários

  Auth                POST           /api/auth/login        Autenticação e
                                                            retorno do Token

  Youtube             POST           /api/youtube/convert   Converte link em
                                                            MP3 (Assíncrono)

  Playlist            GET            /api/playlist          Lista as músicas do
                                                            usuário logado

  Playlist            DELETE         /api/playlist/{id}     Remove a música e o
                                                            arquivo físico

  Stems               POST           /api/stems/{id}        Inicia separação de
                                                            faixas por IA
  -----------------------------------------------------------------------------

------------------------------------------------------------------------

## 🛠️ 6. Requisitos de Ambiente

Para rodar o backend, o servidor deve ter instalado:

-   Java 17+
-   Maven
-   FFmpeg (Essencial para conversão e manipulação de áudio)
-   yt-dlp (Para download/extração do YouTube)
-   Python + Spleeter (Opcional -- apenas para separação de faixas)

------------------------------------------------------------------------

## ⚠️ 7. Tratamento de Erros

A API retorna objetos de erro padronizados em caso de falhas:

``` json
{
  "timestamp": "2026-02-24T15:00:00",
  "status": 404,
  "error": "Não Encontrado",
  "message": "Música com ID 10 não encontrada."
}
```
