package com.jssmx.sso.controller;

import com.jssmx.common.utility.CookieUtils;
import com.jssmx.sso.pojo.User;
import com.jssmx.sso.service.PropertiesService;
import com.jssmx.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "user")
@RestController
public class UserController {
    public static final String COOKIE_NAME = "JSSMX_TOKEN";
    @Resource
    private UserService userService;
    @Resource
    private PropertiesService propertiesService;

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String doRegister(){
        return "register";
    }
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }

    /**
     * 根据用户名和密码获取 token
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/doLogin")
    public ResponseEntity<String> doLogin(@RequestParam("username")String username, @RequestParam("password")String password,
    HttpServletRequest request, HttpServletResponse response){
        try {
            String token = userService.doLogin(username,password);
            if(null==token){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }else{
                // 此处可以设置时间，实现自动登录
                CookieUtils.setCookie(request,response,COOKIE_NAME,token);
                return ResponseEntity.ok("success");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据token查出用户
     * @param token
     * @return
     */
    @GetMapping(value = "{token}")
    public ResponseEntity<User> queryUserByToken(@PathVariable("token")String token){
        User user=userService.queryUserByToken(token);
        if(null==user){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }

    /**
     * 检测数据是否可用
     * @param param
     * @param type
     * @return
     */
    @GetMapping(value = "check/{param}/{type}")
    public ResponseEntity<Boolean> check(@PathVariable("param") String param,@PathVariable("type") Integer type){
        Boolean bool = userService.check(param,type);
        if(null == bool){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(bool);
    }

    @PostMapping(value = "/register",produces = "application/json;charset=utf-8")
    public ResponseEntity<String> doRegister(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //校验有错误
            List<String> msgs=new ArrayList<>();
            List<ObjectError> allErrors= bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                String msg=objectError.getDefaultMessage();
                msgs.add(msg);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StringUtils.join(msgs,"|"));
        }

        Boolean bool = userService.saveUser(user);
        if(bool){
            return ResponseEntity.ok(user.toString());
        }else {
            return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES).body("failed");
        }
    }
}
