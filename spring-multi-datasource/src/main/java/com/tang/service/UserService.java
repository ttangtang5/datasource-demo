package com.tang.service;

import com.tang.config.DataSourceType;
import com.tang.config.DynamicRoutingDateSource;
import com.tang.config.UseDataSource;
import com.tang.dao.UserRepository;
import com.tang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-04 21:19
 * @Version 1.0
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @UseDataSource(value = DataSourceType.SOURCE_SECOND)
    public void save() {
        //User user = User.builder()
        //        .id(1)
        //        .name("tang")
        //        .age(16)
        //        .build();
        User user = new User();
        user.setId(1L);
        user.setName("tang");
        user.setAge(16);
        userRepository.save(user);
    }

    @UseDataSource(value = DataSourceType.SOURCE_SECOND)
    public User get() {
        Optional<User> user = userRepository.findById(1L);
        System.out.println("user.get().toString() = " + user.get().toString());
        return user.get();
    }

    public User getSecond() {
        Optional<User> user = userRepository.findById(1L);
        System.out.println("second:==user.get().toString() = " + user.get().toString());
        return user.get();
    }

}
