package com.jssmx.manage.web.controller.system;

import com.jssmx.common.utility.PageData;
import com.jssmx.manage.pojo.system.User;
import com.jssmx.manage.pojo.system.UserPhoto;
import com.jssmx.manage.service.base.PropertiesService;
import com.jssmx.manage.service.system.MessageService;
import com.jssmx.manage.service.system.OnlineServer;
import com.jssmx.manage.service.system.UserPhotoService;
import com.jssmx.manage.service.system.UserService;
import com.jssmx.manage.web.controller.base.BaseController;
import com.jssmx.manage.web.utility.AppUtil;
import com.jssmx.manage.web.utility.Const;
import com.jssmx.manage.web.utility.Jurisdiction;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/head")
public class HeadController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private PropertiesService propertiesService;
    @Resource
    private UserPhotoService userPhotoService;
    @Resource
    private MessageService messageService;

    /**
     * 获取头部信息
     */
    @GetMapping(value = "/getList")
    public Object getList(){
        PageData pd = getPageData();
        Map<String,Object> map = new HashMap<>();
        try {
            List<User> userList = new ArrayList<>();
            Session session = Jurisdiction.getSession();
            User users = (User)session.getAttribute(Const.SESSION_USERPDS);
            String username = Jurisdiction.getUsername();
            if(null == users){
                users=userService.getByUsername(username);
                session.setAttribute(Const.SESSION_USERPDS,users);
            }
            userList.add(users);
            map.put("list",userList);
            UserPhoto userPhoto=userPhotoService.findById(username);

            String url = (null == userPhoto) ? propertiesService.USER_PHOTO_URL : userPhoto.getPhoto2();//用户头像
            map.put("userPhoto",url);

            Integer messageCount=messageService.findMessageCount(username);
            map.put("massageCount",messageCount);

            String webSocketStr = propertiesService.WEBSOCKET;
            if(StringUtils.isNotEmpty(webSocketStr)){
                String strIW[] = webSocketStr.split(",");
                if(strIW.length == 5){
                    map.put("wimadress",strIW[0]+":"+strIW[1]); //即时聊天服务器IP和端口
                    map.put("oladress",strIW[2]+":"+strIW[3]);  //在线管理和站内信服务器IP和端口
                    map.put("messageSound",strIW[4]);           //站内信提示音效配置
                }
            }
        }catch (Exception e){//
            e.printStackTrace();
        }finally {
            logger.info("获取头部信息完成");
        }
        return AppUtil.returnObject(pd,map);
    }

}
