package com.jssmx.manage.mapper.system;

import com.jssmx.manage.pojo.system.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface RoleMapper extends Mapper<Role> {
    Role getRoleByUsername(String username);
}
