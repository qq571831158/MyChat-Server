package com.ch.bean.Message;

import com.ch.bean.IBeanOperation;

/**
 * Created by apple on 2017/3/11.
 */
public class GetMessageIBean extends IBeanOperation{
    private  String fromUser;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
}
