package com.ch.bean;

/**
 * Created by apple on 2017/1/18.
 */
public class UserLoginIBean {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserLoginIBean(){
    }
    public UserLoginIBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
