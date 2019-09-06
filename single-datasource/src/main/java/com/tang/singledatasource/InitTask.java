package com.tang.singledatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-02 21:52
 * @Version 1.0
 **/
@Component
public class InitTask implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("dataSource.getConnection().toString() = " + dataSource.getConnection().toString());
    }
}
