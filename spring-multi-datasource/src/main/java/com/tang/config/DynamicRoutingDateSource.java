package com.tang.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @Description
 * @Author tang
 * @Date 2019-07-03 22:21
 * @Version 1.0
 **/
public class DynamicRoutingDateSource extends AbstractRoutingDataSource {

    private static Logger logger = LoggerFactory.getLogger(DynamicRoutingDateSource.class);

    private static final ThreadLocal<String> dataSourceName = new ThreadLocal<String>();

    /**
     * 设置需使用数据源的名称
     * @param name
     */
    public static void setCurrentDataSource(String name) {
        logger.debug("thread:{},set,dataSource:{}",Thread.currentThread().getName(), name);
        dataSourceName.set(name);
    }

    protected Object determineCurrentLookupKey() {
        logger.debug("thread:{},determine,dataSource:{}",Thread.currentThread().getName(), dataSourceName.get());
        return dataSourceName.get();
    }

    /**
     * 设置为默认数据源
     */
    public static void setDefaultDataSource() {
        logger.debug("thread:{},remove,dataSource:{}",Thread.currentThread().getName(), dataSourceName.get());
        dataSourceName.remove();
    }
}
