package com.jssmx.manage.web.controller.system;

import com.jssmx.manage.service.base.PropertiesService;
import com.jssmx.manage.service.system.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "user")
@RestController
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private PropertiesService propertiesService;

    @GetMapping(value = "/add")
    public Map<String,Object> doLogin(){

        Map<String,Object> result=new HashMap<>();
        String username = "admin";

        result.put("username",username);
        return result;
    }

}
