<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2017/2/21
  Time: 下午10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录 </title>

</head>
<body>
<script type="text/javascript" charset="UTF-8" src="jquery-2.1.1/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="dist/sockjs.min.js"></script>
<%--<script type="text/javascript">--%>
    <%--var websocket = null;--%>
    <%--if ('WebSocket' in window) {--%>
        <%--websocket = new WebSocket("ws://localhost:8080/websocket");--%>
        <%--window.websocket = websocket;--%>

    <%--}--%>
    <%--else if ('MozWebSocket' in window) {--%>
        <%--websocket = new MozWebSocket("ws://localhost:8080/websocket");--%>
    <%--}--%>
    <%--else {--%>
        <%--websocket = new SockJS("http://localhost:8080/sockjs/websocket");--%>
    <%--}--%>
    <%--websocket.onerror = function () {--%>
       <%--// setMessageInnerHTML("WebSocket连接发生错误");--%>
    <%--};--%>
    <%--//连接成功建立的回调方法--%>
    <%--websocket.onopen = function () {--%>
        <%--//setMessageInnerHTML("WebSocket连接成功");--%>
    <%--}--%>
    <%--//接收到消息的回调方法--%>
    <%--websocket.onmessage = function (event) {--%>
        <%--//setMessageInnerHTML(event.data);--%>
    <%--}--%>
    <%--//连接关闭的回调方法--%>
    <%--websocket.onclose = function () {--%>
        <%--//setMessageInnerHTML("WebSocket连接关闭");--%>
    <%--}--%>
    <%--//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。--%>
    <%--window.onbeforeunload = function () {--%>
        <%--closeWebSocket();--%>
    <%--}--%>
    <%--function doSend() {--%>
        <%--if (websocket.readyState == websocket.OPEN) {--%>
            <%--$.ajax({--%>
                <%--type : "POST",--%>
                <%--url : "http://localhost:8080/user/login",--%>
                <%--dataType:"json",--%>
                <%--contentType:"application/json",--%>
                <%--data:JSON.stringify({--%>
                    <%--"username":"cheng",--%>
                    <%--"password":"123456"--%>
                <%--}),--%>
                <%--success:function(data){--%>
                    <%--alert(data.message);--%>
                    <%--localStorage.setItem("websocket",websocket);--%>
                    <%--window.location.href="http://localhost:8080/chat.jsp";--%>
                <%--}--%>
            <%--});--%>
        <%--} else {--%>
            <%--alert("连接失败!");--%>
        <%--}--%>

    <%--}--%>
<%--</script>--%>
<script type="text/javascript">
    function doSend() {
        var username =$("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: "POST",
            url: "http://182.254.152.99:8080/MyChat1/user/login",
//            url: "http://localhost:8080/user/login",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                "username": username,
                "password": password
            }),
            success: function (data) {
                alert(data.message);
                window.location.href = "http://182.254.152.99:8080/MyChat1/chat.jsp?username=" + username;
//                 window.location.href = "http://localhost:8080/chat.jsp?username=" + username;
            }
        });
    }
</script>
    <input type="text" id="username" placeholder="用户名">
    <input type="password" id="password" placeholder="密码">
    <button onclick="doSend()">提交</button>
</body>
</html>
