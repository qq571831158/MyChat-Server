//package com.ch.controller;
//
//import com.ch.bean.OBeanBase;
//import com.ch.utils.SystemWebSocketHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.socket.TextMessage;
//
///**
// * Created by apple on 2017/1/31.
// */
//@Controller
//@RequestMapping(value = "message")
//public class SendMessage {
//    @Bean
//    public SystemWebSocketHandler systemWebSocketHandler() {
//        return new SystemWebSocketHandler();
//    }
//
////
////    @RequestMapping(value = "sendmessagetouser",method = RequestMethod.POST)
////    @ResponseBody
////    public OBeanBase userlogin(@RequestBody  ) {
////        OBeanBase carrier = new OBeanBase();
////        systemWebSocketHandler().sendMessageToUser("username",new TextMessage(""));
////        return carrier;
////    }
//}
