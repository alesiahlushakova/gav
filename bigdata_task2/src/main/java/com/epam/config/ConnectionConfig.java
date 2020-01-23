package com.epam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan(basePackages = {"com.epam"})
public class ConnectionConfig {

    private static final String USER_PROPERTY_KEY = "db.user";
    private static final String PASSWORD_PROPERTY_KEY = "db.password";
    private static final String URL_PROPERTY_KEY = "db.url";
    private static final String DRIVER_PROPERTY_KEY = "db.driver";
    private static final String USER_PROPERTY = "user";
    private static final String PASSWORD_PROPERTY = "password";

    @Autowired
    private Environment environment;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(DRIVER_PROPERTY_KEY));
        dataSource.setUrl(environment.getProperty(URL_PROPERTY_KEY));
        dataSource.setUsername(environment.getProperty(USER_PROPERTY_KEY));
        dataSource.setPassword(environment.getProperty(PASSWORD_PROPERTY_KEY));

        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
