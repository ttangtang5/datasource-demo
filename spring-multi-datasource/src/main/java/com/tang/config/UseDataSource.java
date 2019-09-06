package com.tang.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-03 22:38
 * @Version 1.0
 **/
@Target(value = {ElementType.FIELD,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UseDataSource {

    /**
     * 数据源
     * @return
     */
    DataSourceType value() default DataSourceType.SOURCE_FIRST;

    /**
     * 是否使用hashKey,若为true,则使用对应字段的哈希值进行计算，选择数据源，
     * 且指定的{@link DataSourceType}不起作用
     * @return
     */
    boolean useHashKey() default false;

}
