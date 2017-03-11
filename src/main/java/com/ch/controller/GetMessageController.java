package com.ch.controller;

import com.ch.DAO.MessageDAO;
import com.ch.bean.Message.GetMessageIBean;
import com.ch.bean.OBeanBase;
import com.ch.model.Message;
import com.ch.utils.OBeanConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by apple on 2017/3/11.
 */
@Controller
@RequestMapping(value = "message")
public class GetMessageController {
    @Resource
    MessageDAO dao;
    @Resource userpool userpool;
    @RequestMapping(value = "/getUnReadMessage", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase GetMessage(@RequestBody GetMessageIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            String hql ="FROM Message WHERE messageTouser = ? and messageIsread = 0 ORDER BY messageTime";
            try {
                List<Message> messages = dao.findByHQL(hql,iBean.getUsername());
                if(messages.size()==0){
                    carrier.setInfo("S02","暂无未读消息");
                }
                else {
                    carrier.setInfo("S01", "查询成功");
                    carrier.setContents(OBeanConverter.messagesToMessageOBean(messages));
                }
            }
            catch (Exception e){
                e.printStackTrace();
                carrier.setInfo("E01",e.getMessage());
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase updateStatus(@RequestBody GetMessageIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            try {
                dao.updataStatus(iBean.getUsername());
                carrier.setInfo("S01","操作成功");
            }
            catch (Exception e){
                e.printStackTrace();
                carrier.setInfo("E01",e.getMessage());
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

}
