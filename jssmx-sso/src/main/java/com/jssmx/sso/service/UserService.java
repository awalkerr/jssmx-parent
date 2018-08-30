package com.jssmx.sso.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jssmx.common.service.RedisService;
import com.jssmx.sso.mapper.UserMapper;
import com.jssmx.sso.pojo.User;
import com.jssmx.sso.service.BaseService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class UserService extends BaseService<User> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Integer REDIS_TIME = 60 * 60 * 24 * 30 * 3;
    private static final String PREFIX = "TOKEN_";
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;

    public String doLogin(String username, String password) throws Exception{
        User record = new User();
        record.setUsername(username);
        record.setPassword(DigestUtils.md5Hex(password));
        User user = this.queryOne(record);
        if(null==user){
            return null;
        }

        String token = DigestUtils.md5Hex(System.currentTimeMillis()+user.getUsername());
        redisService.set(PREFIX+token, MAPPER.writeValueAsString(user), REDIS_TIME);

        return token;
    }

    public User queryUserByToken(String token){
        String key = PREFIX+token;
        String jsonData=redisService.get(key);
        if(StringUtils.isEmpty(jsonData)){
            return null;
        }
        try {
            redisService.expire(key,REDIS_TIME);
            return MAPPER.readValue(jsonData,User.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Boolean check(String param,Integer type){
        if (type<1 || type>3){
            return null;
        }
        User record=new User();
        switch (type){
            case 1:
                record.setUsername(param);
                break;
            case 2:
                record.setPhone(param);
                break;
            case 3:
                record.setEmail(param);
                break;
            default:
                break;
        }
        return this.queryOne(record)!=null;
    }

    public Boolean saveUser(User user){
        user.setIp(null);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return this.saveSelective(user) == 1;
    }

}

