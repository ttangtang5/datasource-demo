package com.tang.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Description 数据源切换切面 需要注意下该切面必须要在事务注解@Transactional之前，
 * 由于在开始事务之前就需要确定数据源，所以设置DataSourceAspect的@Order(Ordered.LOWEST_PRECEDENCE-1)，@Transactional的order是最小值
 * order数字小先执行
 * @Author tang
 * @Date 2019-07-03 22:55
 * @Version 1.0
 **/
@Component
@Aspect
@EnableAspectJAutoProxy
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class DataSourceAspect {

    @Pointcut(value = "@annotation(com.tang.config.UseDataSource)")
    public void useDataSource() {
    }

    /**
     * useDataSource() && @annotation(anno)
     * userDataSource为上面的切点规则，@annotation（anno）表示连接点的（目标对象方法）
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("useDataSource() && @annotation(anno)")
    public Object dataSourceSwitcher(ProceedingJoinPoint joinPoint, UseDataSource anno) throws Throwable {
        String ds = "";
        //若使用hashkey，则根据hashkey进行选择数据源
        if (anno.useHashKey()) {
            ds = DataSourceType.getByKey(getHashKeyFromMethod(joinPoint));
        } else {
            //直接获取数据源
            DataSourceType value = anno.value();
            ds = value.getName();
        }
        //设置数据源
        DynamicRoutingDateSource.setCurrentDataSource(ds);
        try {
            //执行方法
            Object result = joinPoint.proceed();
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            //切换回原来的数据源（重要）
            DynamicRoutingDateSource.setCurrentDataSource(DataSourceType.SOURCE_FIRST.getName());
        }
    }

    /**
     * @param joinPoint
     * @return
     */
    public String getHashKeyFromMethod(ProceedingJoinPoint joinPoint){
        MethodSignature signature=MethodSignature.class.cast(joinPoint.getSignature());
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        Parameter[] declaredFields = method.getParameters();
        int index=0;
        for(Parameter temp:declaredFields){
            Annotation[] annotations = temp.getAnnotations();
            for(Annotation anTemp:annotations){
                if(anTemp instanceof DSKey){
                    return String.valueOf(args[index]);
                }
            }
            index++;
        }
        throw new RuntimeException("can not get field with @DsKey annotation");
    }

}
