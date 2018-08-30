package com.jssmx.manage.service.oa;

import com.jssmx.manage.mapper.oa.DataJurMapper;
import com.jssmx.manage.pojo.oa.DataJur;
import com.jssmx.manage.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DataJurService extends BaseService<DataJur> {

    @Resource
    private DataJurMapper dataJurMapper;

    public DataJur getDataJurByUsername(String username) {
        return dataJurMapper.getDataJurByUsername(username);
    }

}
