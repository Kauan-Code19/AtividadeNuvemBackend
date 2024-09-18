package com.kauanProjects.CRUD_AtividadeNuvem.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${allowed.origins}")
    private String allowedOrigins;

    /**
     * Configures CORS settings for the application.
     *
     * @return a WebMvcConfigurer object with customized CORS settings
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * Adds CORS mappings to allow cross-origin requests from specified origins.
             *
             * @param registry the CorsRegistry object to configure CORS settings
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Configures CORS to allow requests from all paths
                registry.addMapping("/**")
                        // Permite solicitações da origem especificada
                        .allowedOrigins(allowedOrigins)
                        // Permite todos os métodos HTTP (GET, POST, PUT, DELETE, etc.)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Permite todos os cabeçalhos HTTP
                        .allowedHeaders("*")
                        // Permite que credenciais (cookies, cabeçalhos de autorização, etc.) sejam incluídas nas
                        // solicitações
                        .allowCredentials(true);
            }
        };
    }
}

