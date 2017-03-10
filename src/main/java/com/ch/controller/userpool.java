package com.ch.controller;

import com.ch.bean.IBeanOperation;
import com.ch.bean.userpoolBean;
import com.ch.utils.DataEncoder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by apple on 2017/1/18.
 */
@Component
public class userpool extends HashMap<String, userpoolBean> {
    public userpool() {
    }
    public void add(String username) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long time = calendar.getTimeInMillis();
        String md5 = DataEncoder.getMD5("mybookshop" + username + time);
        userpoolBean user = new userpoolBean();
        user.setUsername(username);
        user.setVaild(time);
        user.setSessionID(md5);
        this.put(username, user);
    }
    public void removeUserBean(String userID) {
        this.remove(userID);
    }
    public String getUserSessionID(String userID) {
        userpoolBean user = (userpoolBean)this.get(userID);
        return user != null?user.getSessionID():null;
    }
    public Boolean checkUser(String userID, String sessionID) {
        userpoolBean user = (userpoolBean)this.get(userID);
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        if(user != null && user.getSessionID().equals(sessionID) && time <= user.getVaild()) {
            calendar.add(2, 1);
            long newtime = calendar.getTimeInMillis();
            user.setVaild(newtime);
            return true;
        } else {
            return false;
        }
    }
    public Boolean checkUser(IBeanOperation iBeanOperation) {
        return this.checkUser(iBeanOperation.getUsername(), iBeanOperation.getSessionID());
    }
}
