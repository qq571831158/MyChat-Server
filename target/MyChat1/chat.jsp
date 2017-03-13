<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2017/2/22
  Time: 下午3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天</title>
</head>
<body>
<script type="text/javascript" charset="UTF-8" src="jquery-2.1.1/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="dist/sockjs.min.js"></script>
<script type="text/javascript">
    var username = getParam('username');
    function getParam(paramName) {
        paramValue = "";
        isFound = false;
        if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
            arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&");
            i = 0;
            while (i < arrSource.length && !isFound) {
                if (arrSource[i].indexOf("=") > 0) {
                    if (arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase()) {
                        paramValue = arrSource[i].split("=")[1];
                        isFound = true;
                    }
                }
                i++;
            }
        }
        return paramValue;
    }
    var websocket = null;
    if ('WebSocket' in window) {
//        websocket = new WebSocket("ws://182.254.152.99:8080/MyChat1/websocket/"+username);
        websocket = new WebSocket("ws://localhost:8080/websocket/"+username);
        window.websocket = websocket;

    }
    else if ('MozWebSocket' in window) {
//        websocket = new MozWebSocket("ws://182.254.152.99:8080/MyChat1/websocket");
        websocket = new MozWebSocket("ws://localhost:8080/MyChat1/websocket");
    }
    else {
        websocket = new SockJS("http://182.254.152.99:8080/MyChat1/sockjs/websocket");
//        websocket = new MozWebSocket("ws://localhost:8080/MyChat1/websocket");
    }
    websocket.onerror = function () {
        // setMessageInnerHTML("WebSocket连接发生错误");
    };
    //连接成功建立的回调方法
    websocket.onopen = function () {
        //setMessageInnerHTML("WebSocket连接成功");
    }
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        //setMessageInnerHTML(event.data);
        alert(event.data);
    }
    //连接关闭的回调方法
    websocket.onclose = function () {
        //websocket.send("关闭");
        //setMessageInnerHTML("WebSocket连接关闭");
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }
    function onSend() {
        if (websocket.readyState == websocket.OPEN) {
            var message = JSON.stringify({
                "fromUser": username,
                "toUser": $("#touser").val(),
                "message":$("#content").val()
            });
            websocket.send(message);
        } else {
            alert("连接失败!");
        }

    }
</script>
<input type="text" id="touser" placeholder="发送给谁">
<input type="text" id="content" placeholder="发送内容">
<button onclick="onSend()">发送</button>
</body>
</html>
