package com.ch.controller;

import com.ch.DAO.UserDAO;
import com.ch.bean.OBeanBase;
import com.ch.bean.UserLoginIBean;
import com.ch.bean.UserloginOBean;
import com.ch.model.Userinfo;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 2017/1/18.
 */
@Controller
@RequestMapping(value="/user")
public class UserInfoController {
    String ip;
    int port;
    @Resource
    userpool userpool;
    @Resource
    UserDAO dao;
    @Autowired
    private  HttpServletRequest request;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase userlogin(@RequestBody UserLoginIBean user ) {
        OBeanBase carrier = new OBeanBase();
        Userinfo use = dao.findById(user.getUsername());
        if (use != null) {
            if (use.getPassword().equals(user.getPassword())) {
                userpool.add(user.getUsername());
                String SessionID = userpool.getUserSessionID(user.getUsername());
                if (SessionID == null) {
                    carrier.setInfo("E03", "服务器繁忙");
                } else {
                    carrier.setInfo("S01", "登陆成功");
                    getIpAddr1(request);
                    request.getSession().setAttribute("username",user.getUsername());
                    carrier.setContents(new UserloginOBean(SessionID,user.getUsername(), use.getNickname(),use.getUserPicture(),this.ip,this.port));
                }
            } else {
                carrier.setInfo("E02", "密码错误");
            }
        } else {
            carrier.setInfo("E01", "账户不存在");
        }
        return carrier;
    }

    @RequestMapping(value = "/loginPic",method = RequestMethod.GET)
    @ResponseBody
    public OBeanBase getLoginPic(@RequestParam("username")String username){
        System.out.println(username.getClass()+"         "+ username);
        OBeanBase carrier = new OBeanBase();
        String hql = "FROM Userinfo WHERE username = ?";
        Object[] userPicture = dao.getUserLoginPic(username);
        if (userPicture.length!=0){
            Map<String,String> map = new HashMap<String, String>();
            map.put("user_picture",userPicture[0].toString());
            carrier.setInfo("S01","查询成功");
            carrier.setContents(map);
        }
        else {
            carrier.setInfo("E01","无此用户");
        }
        return carrier;
    }


    public void getIpAddr1(HttpServletRequest request) {
        int port = request.getRemotePort();
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }

                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));

            }
        }
        this.port = port;
        this.ip = ipAddress;
    }
}
