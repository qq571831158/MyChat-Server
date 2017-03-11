package com.ch.utils;

import com.ch.DAO.MessageDAO;
import com.ch.bean.FriendInfoOBean;
import com.ch.bean.Message.GetMessageOBean;
import com.ch.bean.UserloginOBean;
import com.ch.model.Message;
import com.ch.model.Userinfo;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/3/8.
 */
public class OBeanConverter {
    public static List<FriendInfoOBean>userInfoToFriendOBean(List<Userinfo> userinfos) {
        List<FriendInfoOBean> outlist = new ArrayList<FriendInfoOBean>();
        for (Userinfo u :userinfos){
            FriendInfoOBean bean = new FriendInfoOBean();
            bean.setUsername(u.getUsername());
            bean.setNickname(u.getNickname());
            bean.setUser_picture(u.getUserPicture());
            outlist.add(bean);
        }
        return outlist;
    }

    public static List<GetMessageOBean> messagesToMessageOBean(List<Message> messages){
        List<GetMessageOBean> outlist = new ArrayList<GetMessageOBean>();
        for (Message m:messages){
            GetMessageOBean message = new GetMessageOBean();
            message.setFromUser(m.getMessageFromuser());
            message.setTimestamp(m.getMessageTime());
            message.setMessage(m.getMessageContent());
            outlist.add(message);
        }
        return outlist;
    }
}
