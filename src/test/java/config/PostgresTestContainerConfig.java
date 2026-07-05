package config;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.testcontainers.postgresql.PostgreSQLContainer;

public class PostgresTestContainerConfig implements QuarkusTestResourceLifecycleManager {

    private PostgreSQLContainer postgresContainer;

    @Override
    public Map<String, String> start() {
        postgresContainer = new PostgreSQLContainer("postgres:latest");
        postgresContainer.start();

        final Map<String, String> dbProperties = createPostgresProperties();

        System.out.printf("""
                ***************************************************
                **************** POSTGRES SQL INFO ****************
                Jdbc URL: %s
                Username: %s
                Password: %s
                ***************************************************
                ***************************************************
                """.formatted(
            postgresContainer.getJdbcUrl(),
            postgresContainer.getUsername(),
            postgresContainer.getPassword())
        );

        return Collections.unmodifiableMap(dbProperties);
    }

    private Map<String, String> createPostgresProperties() {
        final Map<String, String> dbProperties = new HashMap<>();
        dbProperties.put("quarkus.datasource.jdbc.url", postgresContainer.getJdbcUrl());
        dbProperties.put("quarkus.datasource.username", postgresContainer.getUsername());
        dbProperties.put("quarkus.datasource.password", postgresContainer.getPassword());
        return dbProperties;
    }

    @Override
    public void stop() {
        if (postgresContainer != null) {
            postgresContainer.close();
        }
    }
}
