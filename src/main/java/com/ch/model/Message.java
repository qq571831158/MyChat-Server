package com.ch.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by apple on 2017/3/4.
 */
@Entity
public class Message {
    private int sid;
    private String messageFromuser;
    private String messageTouser;
    private String messageContent;
    private Timestamp messageTime;
    public Message(){}
    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "message_fromuser")
    public String getMessageFromuser() {
        return messageFromuser;
    }

    public void setMessageFromuser(String messageFromuser) {
        this.messageFromuser = messageFromuser;
    }

    @Basic
    @Column(name = "message_touser")
    public String getMessageTouser() {
        return messageTouser;
    }

    public void setMessageTouser(String messageTouser) {
        this.messageTouser = messageTouser;
    }

    @Basic
    @Column(name = "message_content")
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "message_time")
    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (sid != message.sid) return false;
        if (messageFromuser != null ? !messageFromuser.equals(message.messageFromuser) : message.messageFromuser != null)
            return false;
        if (messageTouser != null ? !messageTouser.equals(message.messageTouser) : message.messageTouser != null)
            return false;
        if (messageContent != null ? !messageContent.equals(message.messageContent) : message.messageContent != null)
            return false;
        if (messageTime != null ? !messageTime.equals(message.messageTime) : message.messageTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (messageFromuser != null ? messageFromuser.hashCode() : 0);
        result = 31 * result + (messageTouser != null ? messageTouser.hashCode() : 0);
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (messageTime != null ? messageTime.hashCode() : 0);
        return result;
    }
}
