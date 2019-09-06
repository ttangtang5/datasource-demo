package com.tang.controller;

import com.tang.pojo.User;
import com.tang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-04 21:24
 * @Version 1.0
 **/
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String getTest() {
        userService.save();
        User user = userService.get();
        User second = userService.getSecond();
        return "success";
    }
}
