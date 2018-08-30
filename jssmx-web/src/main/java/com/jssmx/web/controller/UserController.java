package com.jssmx.web.controller;

import com.jssmx.web.pojo.User;
import com.jssmx.web.service.PropertiesService;
import com.jssmx.web.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "user")
@RestController
public class UserController {
    public static final String COOKIE_NAME = "JSSMX_TOKEN";
    @Resource
    private UserService userService;
    @Resource
    private PropertiesService propertiesService;


    @RequestMapping(value = "/login_toLogin",method = RequestMethod.GET)
    public Map<String,Object> doLogin(){

        Map<String,Object> result=new HashMap<>();
        String username = "admin";
        List<User> user = userService.getByUsername(username);
//        User user = new User();
//        user.setUsername(username);
//        user.setEmail("1234@qq.com");
//        user.setName("张三");
//        user.setNumber("121222323232");
//        user.setRemark("wodedeedd");
//        userService.saveSelective1(user);

//        User u = userService.queryOne(user);
        System.out.println(user);


        result.put("username",username);
        return result;
    }
}
