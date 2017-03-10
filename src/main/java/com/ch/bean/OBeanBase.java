package com.ch.bean;

/**
 * Created by apple on 2017/1/18.
 */
public class OBeanBase {
    String code;
    String message;
    Object contents;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getContents() {
        return contents;
    }
    public void setContents(Object contents) {
        this.contents = contents;
    }
    public void setInfo(String code,String message){
        this.message = message;
        this.code = code;
    }

}
