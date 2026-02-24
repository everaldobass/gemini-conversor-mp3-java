package br.com.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// Configuração para servir arquivos estáticos da pasta de uploads
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Sobrescreve o método para adicionar manipuladores de recursos
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Define o caminho absoluto da pasta de uploads
        String path = "file:uploads/mp3/";
        
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(path);
    }
}
