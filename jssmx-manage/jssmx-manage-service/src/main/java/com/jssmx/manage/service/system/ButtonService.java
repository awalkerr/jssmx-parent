package com.jssmx.manage.service.system;

import com.jssmx.manage.mapper.system.ButtonMapper;
import com.jssmx.manage.pojo.system.Button;
import com.jssmx.manage.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButtonService extends BaseService<Button> {

    @Resource
    private ButtonMapper buttonMapper;

    public List<Button> listAllQxNameByRoleId(String roleId){
        return buttonMapper.listAllQxNameByRoleId(roleId);
    }
}
