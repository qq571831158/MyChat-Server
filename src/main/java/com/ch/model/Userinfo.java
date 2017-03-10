package com.ch.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by apple on 2017/3/4.
 */
@Entity
public class Userinfo {
    private String username;
    private String password;
    private String nickname;
    private String userPicture;
    public Userinfo(){}
    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "user_picture")
    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userinfo userinfo = (Userinfo) o;

        if (username != null ? !username.equals(userinfo.username) : userinfo.username != null) return false;
        if (password != null ? !password.equals(userinfo.password) : userinfo.password != null) return false;
        if (nickname != null ? !nickname.equals(userinfo.nickname) : userinfo.nickname != null) return false;
        if (userPicture != null ? !userPicture.equals(userinfo.userPicture) : userinfo.userPicture != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (userPicture != null ? userPicture.hashCode() : 0);
        return result;
    }
}
