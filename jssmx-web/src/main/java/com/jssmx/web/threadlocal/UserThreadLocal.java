package com.jssmx.web.threadlocal;


import com.jssmx.web.pojo.User;

public class UserThreadLocal {
    private static final ThreadLocal<User> LOCAL=new ThreadLocal<>();

    public static void set(User user){
        LOCAL.set(user);
    }
    public static User get(){
        return LOCAL.get();
    }
}
