<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html >--%>
<%--<body>--%>
<%--<h2>Hello World!</h2>--%>
<%--<script src="jquery-2.1.1/jquery.min.js"></script>--%>
<%--<script>--%>
    <%--function btn() {--%>
        <%--var a=JSON.stringify({username:"cheng",--%>
            <%--password:"123456"});--%>
        <%--$.ajax({--%>

            <%--type: "POST",--%>
            <%--url: "http://192.168.125.121:8080/user/login",--%>
            <%--//url:"http://123.206.207.212/MyChat1/user/login",--%>
            <%--contentType: "application/json",--%>
            <%--dataType: "json",--%>
            <%--data: a,--%>
            <%--success: function (data) {--%>
                <%--alert(data.contents.ip);--%>
            <%--},--%>
            <%--error: function () {--%>
                <%--alert('error')--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>
<%--</body>--%>
    <%--<input type="text" name="username" >--%>
    <%--<input type="password" name="password" >--%>
    <%--<input type="button" onclick="btn()" value="提交">--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Java API for WebSocket (JSR-356)</title>
</head>
<body>
<script type="text/javascript" charset="UTF-8" src="jquery-2.1.1/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="dist/sockjs.min.js"></script>
<script type="text/javascript">
    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/websocket");
    }
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8080/websocket");
    }
    else {
        websocket = new SockJS("http://localhost:8080/sockjs/websocket");
    }
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };
    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }
    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }
</script>
请输入：<textarea rows="5" cols="10" id="inputMsg" name="inputMsg"></textarea>
<button onclick="doSend();">发送</button>
</body>
</html>