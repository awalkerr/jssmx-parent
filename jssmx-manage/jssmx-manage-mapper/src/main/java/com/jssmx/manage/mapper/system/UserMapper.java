package com.jssmx.manage.mapper.system;

import com.jssmx.common.utility.PageData;
import com.jssmx.manage.pojo.system.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 根据邮箱或者用户名和密码 查询用户
     * @param pd
     * @return
     */
    User getUserByLoginNameAndPwd(PageData pd);

    /**
     * 根据用户ID查询用户
     * @param userId
     * @return
     */
    User getUserAndRoleById(String userId);
}
