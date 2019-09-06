package com.tang.multidatasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 16:20
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {

    @Resource
    private DataSource fooDataSource;

    @Resource
    private DataSource barDataSource;

    @Bean
    @Primary
    public DynamicRoutingDataSource dynamicRoutingDataSource() {
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        dynamicRoutingDataSource.setDefaultTargetDataSource(fooDataSource);
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("fooDataSource", fooDataSource);
        dataSourceMap.put("barDataSource", barDataSource);
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        return dynamicRoutingDataSource;
    }

    @Bean
    @Resource
    public PlatformTransactionManager transactionManager(DataSource DynamicRoutingDataSource) {
        return new DataSourceTransactionManager(DynamicRoutingDataSource);
    }

   @Primary
   @Bean(name = "entityManagerFactory")
   public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
       LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
       bean.setDataSource(this.dynamicRoutingDataSource());
       bean.setPackagesToScan("com.tang.multidatasource.pojo");
       bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

       Map<String, String> map = new HashMap<>();
       map.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
       map.put("hibernate.hbm2ddl.auto", "update");
       map.put("hibernate.show_sql", "true");
       map.put("hibernate.format_sql", "true");
       map.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

       bean.setJpaPropertyMap(map);
       return bean;
   }

}
