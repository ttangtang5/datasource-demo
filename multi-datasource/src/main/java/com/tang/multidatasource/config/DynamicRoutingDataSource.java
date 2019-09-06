package com.tang.multidatasource.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 16:11
 * @Version 1.0
 **/
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    private static final ThreadLocal<String> dataSourceName = new ThreadLocal<>();

    public static void setUseDataSource(String name) {
        dataSourceName.set(name);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceName.get();
    }

    public static void useDefaultDataSource() {
        dataSourceName.remove();
    }
}
