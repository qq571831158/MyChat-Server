package com.ch.bean;

/**
 * Created by apple on 2017/1/18.
 */
public class userpoolBean {
    String username;
    String sessionID;
    long vaild;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    public void setVaild(long vaild) {
        this.vaild = vaild;
    }
    public String getSessionID() {
        return sessionID;
    }
    public long getVaild() {
        return vaild;
    }
    public userpoolBean(){}
}
