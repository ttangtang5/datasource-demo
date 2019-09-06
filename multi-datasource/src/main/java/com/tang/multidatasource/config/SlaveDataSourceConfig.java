package com.tang.multidatasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-10 21:50
 * @Version 1.0
 **/
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactorySlave",
//        transactionManagerRef = "transactionManagerSlave",
//        basePackages = {"com.tang.multidatasource.dao"}
//)
public class SlaveDataSourceConfig {

    @Autowired
    private DynamicRoutingDataSource dataSource;


    @Bean("entityManagerFactorySlave")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .packages("com.tang.datasource")
                .build();
    }


    @Bean("entityManagerSlave")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return localContainerEntityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Bean("transactionManagerSlave")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean(builder).getObject());
    }

}

