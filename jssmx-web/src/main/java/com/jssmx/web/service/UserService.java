package com.jssmx.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jssmx.common.service.ApiService;
import com.jssmx.web.pojo.User;
import com.jssmx.web.service.PropertiesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private PropertiesService propertiesService;
    @Autowired
    private ApiService apiService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public List<User> getByUsername(String username){
        User  user = new User();
        user.setUsername(username);

        return null;
    }

    public User queryUserByToken(String token){
        String url = propertiesService.JSSMX_SSO_URL+"/user/"+token;
        try {
            String jsonData = apiService.doGet(url);
            if(StringUtils.isNotEmpty(jsonData)){
                return MAPPER.readValue(jsonData,User.class);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}

