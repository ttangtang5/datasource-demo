package com.tang.multidatasource.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-03 21:35
 * @Version 1.0
 **/
@Configuration
public class FooDataSourceConfig {

    @Bean(name = "fooDataSourceProperties")
    @ConfigurationProperties(prefix = "foo.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "fooDataSource")
    public DataSource datasource() {
        return this.dataSourceProperties().initializeDataSourceBuilder().build();
    }

    //@Bean
    //@Resource
    //public PlatformTransactionManager transactionManager(DataSource fooDataSource) {
    //    return new DataSourceTransactionManager(fooDataSource);
    //}
}
