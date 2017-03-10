package com.ch.bean;

/**
 * Created by apple on 2017/3/9.
 */
public class ReceiveMessageBean {
    private String fromUser;
    private String toUser;
    private String message;
    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReceiveMessageBean(){}
    public ReceiveMessageBean(String fromUser, String message, String toUser) {
        this.fromUser = fromUser;
        this.message = message;
        this.toUser = toUser;
    }
}
