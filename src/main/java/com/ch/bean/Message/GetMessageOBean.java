package com.ch.bean.Message;

import java.sql.Timestamp;

/**
 * Created by apple on 2017/3/11.
 */
public class GetMessageOBean {
    private String fromUser;
    private Timestamp timestamp;
    private String message;
    public GetMessageOBean(){}
    public GetMessageOBean(String fromUser, Timestamp timestamp, String message) {
        this.fromUser = fromUser;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
