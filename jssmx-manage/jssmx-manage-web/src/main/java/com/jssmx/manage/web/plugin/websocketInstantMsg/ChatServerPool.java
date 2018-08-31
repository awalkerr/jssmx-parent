package com.jssmx.manage.web.plugin.websocketInstantMsg;

import org.java_websocket.WebSocket;

import java.util.*;

/**
 * 即时通讯
 */
public class ChatServerPool {
    private static final Map<WebSocket,String> userConnections = new HashMap<>();

    /**
     * 获取用户名
     * @param conn
     * @return
     */
    public static String getUserKey(WebSocket conn){
        return userConnections.get(conn);
    }

    /**
     * 获取WebSocket
     * @param user
     * @return
     */
    public static WebSocket getWebSocketByUser(String user){
        Set<WebSocket> keySet = userConnections.keySet();
        synchronized (keySet){
            for (WebSocket conn:keySet){
                String cuser = userConnections.get(conn);
                if(cuser.equals(user)){
                    return conn;
                }
            }
        }
        return null;
    }

    /**
     * 向连接池中添加连接
     * @param user
     * @param conn
     */
    public static void addUser(String user,WebSocket conn){
        userConnections.put(conn,user);
    }

    /**
     * 获取所以的在线用户
     * @return
     */
    public static Collection<String> getOnlineUser(){
        List<String> setUsers = new ArrayList<>();
        Collection<String> setUser = userConnections.values();
        for(String u:setUser){
            setUsers.add("<a onclick=\"toUserMsg('"+u+"');\">"+u+"</a>");
        }
        return setUsers;
    }

    /**
     * 移除连接池中的连接
     * @param conn
     * @return
     */
    public static boolean removeUser(WebSocket conn){
        if(userConnections.containsKey(conn)){
            userConnections.remove(conn);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 向特定的用户发送数据
     * @param conn
     * @param message
     */
    public static void setMessageToUser(WebSocket conn,String message){
        if(null != conn && null != userConnections.get(conn)){
            conn.send(message);
        }
    }

    /**
     * 向所有的用户发送消息
     */
    public static void sendMessage(String message){
        Set<WebSocket> keySet = userConnections.keySet();
        synchronized (keySet){
            for (WebSocket conn:keySet){
                String user = userConnections.get(conn);
                if(user != null){
                    conn.send(message);
                }
            }
        }
    }
}
