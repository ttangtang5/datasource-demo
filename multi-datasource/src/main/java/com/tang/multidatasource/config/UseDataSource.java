package com.tang.multidatasource.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 使用数据源注解
 * @Author tang
 * @Date 2019-07-06 16:04
 * @Version 1.0
 **/
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UseDataSource {

    DataSourceType value() default DataSourceType.SOURCE_MASTER;

    boolean isHashKey() default false;
}
