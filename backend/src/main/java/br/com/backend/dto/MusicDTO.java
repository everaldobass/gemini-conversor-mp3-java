package br.com.backend.dto;

// DTO para representar os dados de uma música
public record MusicDTO(
    Long id,
    String titulo,
    String artista,
    String duracao,
    String caminhoArquivo
) {}
