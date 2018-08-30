package com.jssmx.manage.service.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jssmx.common.service.ApiService;
import com.jssmx.common.utility.DateUtil;
import com.jssmx.common.utility.PageData;
import com.jssmx.manage.mapper.system.UserMapper;
import com.jssmx.manage.pojo.system.User;
import com.jssmx.manage.service.base.BaseService;
import com.jssmx.manage.service.base.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class UserService extends BaseService<User> {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private PropertiesService propertiesService;
    @Autowired
    private ApiService apiService;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 根据主键更新时间
    public void updateLastLogin(User u){
        User user = new User();
        user.setId(u.getId());
        user.setLastLogin(DateUtil.getTime());
        this.updateSelective(user);
    }

    // 根据登录名和密码获取用户
    public User getUserByLoginNameAndPwd(PageData pd){
        return userMapper.getUserByLoginNameAndPwd(pd);
    }

    public User getUserAndRoleById(String userId){
        return userMapper.getUserAndRoleById(userId);
    }

    public User getByUsername(String username){
        User menu = new User();
        menu.setUsername(username);
        return queryOne(menu);
    }

    public void updateRemoteIP(String username,String ip){
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        User user = new User();
        user.setIp(ip);
        userMapper.updateByExampleSelective(user,example);
    }

}

