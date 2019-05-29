package com.args.sigi.util;


import java.util.Map;

import org.zkoss.zk.ui.Sessions;

import com.args.sigi.object.User;


public class AccessControl {


    static Map<String, Object> params = null;

    private static boolean needUpdate = true;


    public static User loadCurrentAccount() throws  Exception {
        return (User) Sessions.getCurrent().getAttribute(WebConstants.SESSION_USER);
    }

    
    public static User setCurrentAccount(User user) throws  Exception {
        return (User) Sessions.getCurrent().setAttribute(WebConstants.SESSION_USER,user);
    }

    



    


    


   
}
