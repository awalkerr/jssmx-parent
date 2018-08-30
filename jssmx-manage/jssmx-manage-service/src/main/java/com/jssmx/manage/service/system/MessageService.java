package com.jssmx.manage.service.system;

import com.jssmx.manage.mapper.system.MessageMapper;
import com.jssmx.manage.pojo.system.Message;
import com.jssmx.manage.service.base.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class MessageService extends BaseService<Message> {
    @Resource
    private MessageMapper messageMapper;

    public Integer findMessageCount(String username){
        Example example = new Example(Message.class);
        example.createCriteria()
                .andEqualTo("state","2")
                .andEqualTo("type","1")
                .andEqualTo("fromUsername",username);

        return messageMapper.selectCountByExample(example);
    }
}
