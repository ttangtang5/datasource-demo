package com.tang.multidatasource.service;

import com.oracle.tools.packager.Log;
import com.tang.multidatasource.dao.UserRepository;
import com.tang.multidatasource.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 17:29
 * @Version 1.0
 **/
@Service
@Transactional
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User get(){
        Optional<User> user = userRepository.findById(1L);
        return user.get();
    }

    public void delete() {
        userRepository.deleteById(1L);
    }

    public void save() {
        User user = User.builder()
                .id(1L)
                .name("tang")
                .age(16)
                .build();
        System.out.println(" print save sql start=====");
        User save = userRepository.save(user);
        System.out.println(" print save sql end=====");
        long count = userRepository.count();
        System.out.println(111);
    }
}
