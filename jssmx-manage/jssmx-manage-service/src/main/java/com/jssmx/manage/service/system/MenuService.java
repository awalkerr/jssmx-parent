package com.jssmx.manage.service.system;

import com.jssmx.manage.mapper.system.MenuMapper;
import com.jssmx.manage.pojo.system.Menu;
import com.jssmx.manage.service.base.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService extends BaseService<Menu> {

    @Resource
    private MenuMapper menuMapper;


    public List<Menu> listAllMenuQx(String menuId){
        List<Menu> menuList = listSubMenuByParentId(menuId);
        for(Menu menu:menuList){
            menu.setSubMenu(listAllMenuQx(menu.getId()));
            menu.setTarget("treeFrame");
        }
        return menuList;
    }


    public List<Menu> listSubMenuByParentId(String parentId){
        Example example=new Example(Menu.class);
        example.createCriteria().andEqualTo("parentId",parentId);
        example.orderBy("orderId");
        return menuMapper.selectByExample(example);
    }

}
