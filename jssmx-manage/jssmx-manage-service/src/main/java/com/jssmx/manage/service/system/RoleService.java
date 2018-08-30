package com.jssmx.manage.service.system;

import com.jssmx.manage.mapper.system.RoleMapper;
import com.jssmx.manage.pojo.system.Role;
import com.jssmx.manage.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService extends BaseService<Role> {

    @Resource
    private RoleMapper roleMapper;

    public Role getRoleByUsername(String username){
        return roleMapper.getRoleByUsername(username);
    }

}
