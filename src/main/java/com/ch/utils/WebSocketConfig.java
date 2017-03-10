//package com.ch.utils;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//
//
///**
// * Created by apple on 2017/1/27.
// */
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
//        webSocketHandlerRegistry.addHandler(systemWebSocketHandler(), "/webSocketServer").addInterceptors(new MyHandshakeInterceptor());
//        System.out.println("registed!");
//        webSocketHandlerRegistry.addHandler(systemWebSocketHandler(), "/sockjs/webSocketServer").addInterceptors(new MyHandshakeInterceptor()).withSockJS();
//
//    }
//
//    @Bean
//    public WebSocketHandler systemWebSocketHandler(){
//        return new SystemWebSocketHandler();
//    }
//}
