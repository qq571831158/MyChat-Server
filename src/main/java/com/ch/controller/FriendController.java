package com.ch.controller;

import com.ch.DAO.FriendDAO;
import com.ch.bean.FriendInfoOBean;
import com.ch.bean.OBeanBase;
import com.ch.utils.OBeanConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by apple on 2017/3/4.
 */
@Controller
@RequestMapping(value="/user")
public class FriendController {
    @Resource
    FriendDAO dao;
    @RequestMapping(value = "/friend", method = RequestMethod.GET)
    @ResponseBody
    public OBeanBase friendList(@RequestParam("username") String username) {
        OBeanBase carrier = new OBeanBase();
        try {
            List<FriendInfoOBean>userinfo = OBeanConverter.userInfoToFriendOBean(dao.findFriendByOwner(username));
            if(userinfo==null)
                carrier.setInfo("S02","暂无好友");
            else {
                carrier.setInfo("S01","查询成功");
                carrier.setContents(userinfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return carrier;
    }
}
