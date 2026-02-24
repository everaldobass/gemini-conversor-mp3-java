package br.com.backend.dto;

// DTO para receber os dados de registro do usuário
public record RegisterDTO(String nome, String email, String senha) {}
