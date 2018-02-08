package ru.test815.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateFactory {
    private DriverManagerDataSource dataSource;
    private Settings settings;
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateFactory(){
        settings = Settings.getInstance();

        dataSource = new DriverManagerDataSource(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        dataSource.setDriverClassName(settings.value("jdbc.driver_class"));
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
