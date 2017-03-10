package com.ch.bean;

/**
 * Created by apple on 2017/1/18.
 */
public class UserloginOBean {
    String sessionID;
    private String username;
    private String nickname;
    private String user_picture;
    String ip;

    int port;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public UserloginOBean(){
    }
    public UserloginOBean(String sessionID, String username, String nickname, String user_picture, String ip, int port) {
        this.sessionID = sessionID;
        this.username = username;
        this.user_picture = user_picture;
        this.nickname = nickname;
        this.ip = ip;
        this.port = port;
    }
}
