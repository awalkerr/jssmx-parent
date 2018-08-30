package com.jssmx.manage.web.threadlocal;


import com.jssmx.manage.pojo.system.User;

public class UserThreadLocal {
    private static final ThreadLocal<User> LOCAL=new ThreadLocal<>();

    public static void set(User user){
        LOCAL.set(user);
    }
    public static User get(){
        return LOCAL.get();
    }
}
