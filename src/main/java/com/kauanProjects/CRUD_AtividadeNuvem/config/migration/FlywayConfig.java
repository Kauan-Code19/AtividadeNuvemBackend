package com.kauanProjects.CRUD_AtividadeNuvem.config.migration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    private final DataSource dataSource;
    private final String migrationLocation;

    @Autowired
    public FlywayConfig(DataSource dataSource, @Value("${flyway.locations}") String migrationLocation) {
        this.dataSource = dataSource;
        this.migrationLocation = migrationLocation;
    }

    // Configuração do Flyway para ambiente de desenvolvimento
    @Bean
    @Profile("development")
    public Flyway flywayDevelopment() {
        return configureFlyway(migrationLocation + "/development");
    }

    // Configuração do Flyway para ambiente de produção
    @Bean
    @Profile("production")
    public Flyway flywayProduction() {
        return configureFlyway(migrationLocation + "/production");
    }

    // Método privado para configurar o Flyway com base na localização fornecida
    private Flyway configureFlyway(String location) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource) // Define o DataSource a ser usado pelo Flyway

                // Define as localizações das migrações: classepath e a localização dinâmica
                .locations(location)

                .load(); // Carrega a configuração do Flyway

        flyway.migrate(); // Executa a migração do banco de dados

        return flyway; // Retorna o objeto Flyway configurado
    }
}
