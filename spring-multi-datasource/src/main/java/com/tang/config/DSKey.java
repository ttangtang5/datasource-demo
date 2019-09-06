package com.tang.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 数据源选择 注解用在参数上，表示使用对应字段的hashcode来选择数据库
 * @Author tang
 * @Date 2019-07-03 22:51
 * @Version 1.0
 **/
@Target(value = ElementType.PARAMETER)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DSKey {

    String value() default "";
}