package com.sidenis.springbootapp.utils;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResetFlyWaySchemaHistory {
    @Bean
    public FlywayMigrationStrategy clean(){
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
}
