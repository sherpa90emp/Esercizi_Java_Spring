package com.example.demo_jdbc_spring.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {
    @Bean
    public DataSource dataSource() {
        //fornendo un bean di tipo datasource al context di spring, siamo sovrascrivendo il comportamento di default con uno personalizzato

        //dataSource che effettua pool connessioni
        HikariDataSource dataSource = new HikariDataSource();
        //fornisco stringhe di connessione per il db
        dataSource.setJdbcUrl("jdbc:mysql://localhost/spring_acquisti");
        dataSource.setUsername("root");
        //imposto un timeout di connessione al db
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }
}
