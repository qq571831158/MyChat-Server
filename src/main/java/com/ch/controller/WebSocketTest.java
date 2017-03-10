package com.ch.controller;

import com.ch.bean.ReceiveMessageBean;
import net.sf.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
/**
 * Created by apple on 2017/2/7.
 */
@ServerEndpoint("/websocket/{username}")
public class WebSocketTest {
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    //private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();
    //private static List<WebSocketTest> webSocketTestMap = new ArrayList<WebSocketTest>();
    private static final Map<String,Object>webSocketTestMap = new HashMap<String, Object>();
//    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private String username;
    public WebSocketTest(){
    }
    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session){
        //System.out.println(username);
        this.session = session;
        webSocketTestMap.put(username,this);     //加入set中
        addOnlineCount();           //在线数加1
       // System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());

    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        System.out.println("客户端以及关闭");
        webSocketTestMap.remove(this);  //从set中删除
       // subOnlineCount();           //在线数减1
       // System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("session::"+session);
        System.out.println("来自客户端的消息:" + message);
        JSONObject jsonObject=JSONObject.fromObject(message);
        ReceiveMessageBean messageBean=(ReceiveMessageBean)JSONObject.toBean(jsonObject, ReceiveMessageBean.class);
        sendToUser(messageBean.getToUser(),messageBean.getMessage());
        //群发消息
//        for(WebSocketTest item: webSocketTestMap){
//            try {
//                if(item.username.equals("cheng")) {
//
//                    item.sendMessage(message);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                continue;
//            }
//        }

    }
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }
    /**
     * 发送给个人
     * @param username 用户名
     * @param message 消息内容
     */
    public static void sendToUser(String username,String message){
       WebSocketTest web = (WebSocketTest)webSocketTestMap.get(username);
        try {
            web.session.getBasicRemote().sendText(message);
        }catch (IOException e){
            webSocketTestMap.remove(web);
            try {
                web.session.close();
            }catch (IOException ex){

            }
//            String message = String.format("* %s %s",
//                    web.username, "has been disconnected.");
        }

    }
    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
    public static synchronized void addOnlineCount() {
        WebSocketTest.onlineCount++;
    }
    public static synchronized void subOnlineCount() {
        WebSocketTest.onlineCount--;
    }
}
