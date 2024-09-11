package com.kauanProjects.CRUD_AtividadeNuvem.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    @Profile("development") // Especifica que este bean será criado apenas no perfil 'development'
    public DataSource developmentDataSource() {
        return createDataSource();
    }

    @Bean
    @Profile("production") // Especifica que este bean será criado apenas no perfil 'production'
    public DataSource productionDataSource() {
        return createDataSource();
    }

    private DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName); // Define a classe do driver JDBC
        dataSource.setUrl(dataSourceUrl); // Define a URL do banco de dados
        dataSource.setUsername(dataSourceUsername); // Define o nome de usuário para a conexão com o banco de dados
        dataSource.setPassword(dataSourcePassword); // Define a senha para a conexão com o banco de dados

        return dataSource; // Retorna o DataSource configurado
    }
}
