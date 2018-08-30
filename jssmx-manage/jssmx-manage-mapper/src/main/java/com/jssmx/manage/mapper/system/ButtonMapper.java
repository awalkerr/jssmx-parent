package com.jssmx.manage.mapper.system;

import com.jssmx.manage.pojo.system.Button;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ButtonMapper extends Mapper<Button> {
    List<Button> listAllQxNameByRoleId(String roleId);
}
