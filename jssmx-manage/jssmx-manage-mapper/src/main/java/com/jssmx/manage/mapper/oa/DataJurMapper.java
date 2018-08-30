package com.jssmx.manage.mapper.oa;

import com.jssmx.manage.pojo.oa.DataJur;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface DataJurMapper extends Mapper<DataJur> {
    DataJur getDataJurByUsername(String username);
}
