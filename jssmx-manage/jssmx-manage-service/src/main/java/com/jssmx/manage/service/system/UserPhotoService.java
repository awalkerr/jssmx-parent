package com.jssmx.manage.service.system;

import com.jssmx.manage.pojo.system.UserPhoto;
import com.jssmx.manage.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UserPhotoService extends BaseService<UserPhoto> {

    public UserPhoto findById(String username){
        UserPhoto userPhoto = new UserPhoto();
        userPhoto.setUsername(username);
        return this.queryOne(userPhoto);
    }

}
