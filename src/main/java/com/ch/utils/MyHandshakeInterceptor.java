//package com.ch.utils;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//@Component
//public class MyHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        if (request instanceof ServletServerHttpRequest) {
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            HttpSession session = servletRequest.getServletRequest().getSession();
//            if (session != null) {
//                System.out.println("ok");
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
//        System.err.println("有人访问了：");
//        System.err.println(ex.toString());
//
//    }
//}
