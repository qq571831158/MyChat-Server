package com.ch.bean;

/**
 * Created by apple on 2017/3/8.
 */
public class FriendInfoOBean {
    private String username;
    private String nickname;
    private String user_picture;
    public FriendInfoOBean(){}
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

    public FriendInfoOBean(String username, String nickname, String user_picture) {
        this.username = username;
        this.nickname = nickname;
        this.user_picture = user_picture;
    }
}
