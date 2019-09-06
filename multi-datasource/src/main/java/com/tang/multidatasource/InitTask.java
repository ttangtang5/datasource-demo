package com.tang.multidatasource;

import com.tang.multidatasource.config.DataSourceType;
import com.tang.multidatasource.config.DynamicRoutingDataSource;
import com.tang.multidatasource.pojo.User;
import com.tang.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 17:32
 * @Version 1.0
 **/
@Component
public class InitTask implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.save();
        User user1 = userService.get();
        System.out.println("user1 = " + user1.toString());
        DynamicRoutingDataSource.setUseDataSource(DataSourceType.SOURCE_SALVE.getValue());
        User user = userService.get();
        System.out.println("user.toString() = " + user.toString());
    }
}
