package com.tang.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-02 22:23
 * @Version 1.0
 **/
@Configuration
public class CustomDataSource {

    @Bean
    public DataSource dataSource() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "org.h2.Driver");
        properties.setProperty("url", "jdbc:h2:mem:test");
        properties.setProperty("username", "sa");
        properties.setProperty("password", "sa");
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(this.dataSource());
    }

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        DataSource dataSource2 = (DataSource) applicationContext.getBean("dataSource");
        System.out.println("dataSource2.getConnection().toString() = " + dataSource2.getConnection().toString());
    }
}
