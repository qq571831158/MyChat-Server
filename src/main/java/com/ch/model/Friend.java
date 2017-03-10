package com.ch.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by apple on 2017/3/4.
 */
@Entity
public class Friend {
    private int sid;
    private String ownerUsername;
    private String friendUsername;
    public Friend(){}
    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "owner_username")
    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    @Basic
    @Column(name = "friend_username")
    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (sid != friend.sid) return false;
        if (ownerUsername != null ? !ownerUsername.equals(friend.ownerUsername) : friend.ownerUsername != null)
            return false;
        if (friendUsername != null ? !friendUsername.equals(friend.friendUsername) : friend.friendUsername != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (ownerUsername != null ? ownerUsername.hashCode() : 0);
        result = 31 * result + (friendUsername != null ? friendUsername.hashCode() : 0);
        return result;
    }
}
