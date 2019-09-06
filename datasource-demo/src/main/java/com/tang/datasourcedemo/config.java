package com.tang.datasourcedemo;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 17:00
 * @Version 1.0
 **/
@Configuration
public class config {

    @Bean
    @ConfigurationProperties(prefix = "foo.datasource")
    public DataSourceProperties properties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource() {
        return this.properties().initializeDataSourceBuilder().build();
    }
}
