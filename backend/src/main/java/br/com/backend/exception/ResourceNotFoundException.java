package br.com.backend.exception;

// Exceção personalizada para indicar que um recurso não foi encontrado
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
