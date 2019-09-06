package com.tang.multidatasource.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 数据源使用hashKey计算，指定计算参数注解
 * @Author tang
 * @Date 2019-07-06 16:07
 * @Version 1.0
 **/
@Target(value = {ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DSKey {

    String value() default "";
}
