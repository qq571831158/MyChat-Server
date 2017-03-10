package com.ch.bean;

/**
 * Created by apple on 2017/1/18.
 */
public class IBeanOperation {
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    private String sessionID;
}
