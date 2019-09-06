package com.tang.multidatasource.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-03 21:45
 * @Version 1.0
 **/
@Configuration
public class BarDataSourceConfig {

    @Bean(name = "barDataSourceProperties")
    @ConfigurationProperties(prefix = "bar.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "barDataSource")
    public DataSource dataSource() {
        return this.dataSourceProperties().initializeDataSourceBuilder().build();
    }

    // 方式二
    //@Bean(name = "barDataSource")
    //@ConfigurationProperties(prefix = "bar.datasource")
    //public DataSource dataSource() {
    //    return DataSourceBuilder.create().build();
    //}

    //@Bean
    //@Resource
    //public PlatformTransactionManager transactionManager(DataSource barDataSource) {
    //    return new DataSourceTransactionManager(barDataSource);
    //}
}
