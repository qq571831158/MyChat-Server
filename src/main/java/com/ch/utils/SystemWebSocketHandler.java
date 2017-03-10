//package com.ch.utils;
//
//import java.io.IOException;
//import java.util.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//public class SystemWebSocketHandler implements WebSocketHandler {
//    @Autowired
//    HttpServletRequest request;
//
//    private static final ArrayList<WebSocketSession> users;
//
//    static {
//        users = new ArrayList<WebSocketSession>();
//    }
//
//    public SystemWebSocketHandler(){
//
//    }
//
//    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
//
//        System.out.println("连接成功了");
//        System.out.println(webSocketSession);
//        System.out.println("afterConnectionEstablished");
//        System.out.println("getId:" + webSocketSession.getId());
//        System.out.println("getLocalAddress:" + webSocketSession.getLocalAddress().toString());
//        System.out.println("getTextMessageSizeLimit:" + webSocketSession.getTextMessageSizeLimit());
//        System.out.println("getUri:" + webSocketSession.getUri().toString());
//        System.out.println("getPrincipal:" + webSocketSession.getPrincipal());
//       // webSocketSession.sendMessage(new TextMessage("你好".getBytes()));
//       // Map<WebSocketSession,String>map =new HashMap<WebSocketSession, String>();
//         System.out.println("session"+request.getSession().getAttribute("username"));
//        users.add(webSocketSession);
//
//
//
//
//    }
//
//    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
//        System.out.println("关闭连接啦");
//        users.remove(webSocketSession);
//
//    }
//
//    public boolean supportsPartialMessages() {
//        return false;
//    }
//
//    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
//
//    }
//
//    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
//        System.out.println(webSocketSession +"::"+webSocketMessage);
//    }
//    /**
//     * 给所有在线用户发送消息
//     * @param message
//     */
//    public void sendMessageToUsers(TextMessage message) {
//        for (WebSocketSession user : users) {
//            if (user.isOpen()) {
//                try {
//                    user.sendMessage(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void sendMessageToUser(String username,TextMessage message) {
//        for (WebSocketSession user : users) {
//            if (user.getAttributes().get("username").equals(username)) {
//                try {
//                    if (user.isOpen()) {
//                        user.sendMessage(message);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//    }
//}
