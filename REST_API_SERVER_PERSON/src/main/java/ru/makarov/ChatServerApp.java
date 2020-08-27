package ru.makarov;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * MAIN class.
 */
@SpringBootApplication
public class ChatServerApp {
    /**
     * bean for inject liquibase with properties and scripts.
     *
     * @param ds -  datasource.
     * @return - liquibase.
     */
    @Bean
    public SpringLiquibase liquibase(@Qualifier("dataSource") DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
        liquibase.setDataSource(ds);
        return liquibase;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatServerApp.class, args);
    }
}
