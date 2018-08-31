package com.jssmx.manage.web.filter;

import com.jssmx.manage.web.plugin.websocketInstantMsg.ChatServer;
import com.jssmx.manage.web.plugin.websocketOnline.OnlineChatServer;
import org.apache.commons.lang3.StringUtils;
import org.java_websocket.WebSocketImpl;

import javax.servlet.*;
import java.io.*;
import java.util.Properties;

/**
 * 启动tomcat时运行此类
 */
public class LoginFilter implements Filter {

    private static String strInstantMsg;

    /**
     * 读取配置文件
     * @param fileP
     */
    public static void readTxtFile(String fileP) {
        String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""));    //项目路径
        Properties pps = new Properties();
        filePath = filePath.replaceAll("file:/", "");
        filePath = filePath.replaceAll("%20", " ");
        filePath = filePath.trim()+fileP.trim();
        if(filePath.indexOf(":") != 1){
            filePath = File.separator + filePath;
        }
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            pps.load(in);
            strInstantMsg = pps.getProperty("WEBSOCKET");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // 读取配置文件
        readTxtFile("env.properties");
        // 启动即时聊天
        startWebsocketInstantMsg();
        // 启动在线管理
        startWebsocketOnline();
    }

    /**
     * 启动即时聊天服务
     */
    private void startWebsocketInstantMsg(){
        WebSocketImpl.DEBUG = false;
        ChatServer s;

        if(StringUtils.isNotEmpty(strInstantMsg)){
            String strIW[] = strInstantMsg.split(",");
            if(strIW.length == 5){
                s = new ChatServer(Integer.parseInt(strIW[1]));
                s.start();
                System.out.println("websocket服务器启动,端口" + s.getPort());
            }
        }
    }

    /**
     * 启动在线管理服务
     */
    private void startWebsocketOnline(){
        WebSocketImpl.DEBUG = false;
        OnlineChatServer s;
        if(StringUtils.isNotEmpty(strInstantMsg)){
            String strIW[] = strInstantMsg.split(",");
            if(strIW.length == 5){
                s = new OnlineChatServer(Integer.parseInt(strIW[3]));
                s.start();
                System.out.println("websocket服务器启动,端口" + s.getPort());
            }
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
