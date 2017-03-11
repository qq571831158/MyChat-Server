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
<script type="text/javascript">
    function doSend() {
        var username =$("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: "POST",
//            url: "http://182.254.152.99:8080/MyChat1/user/login",
            url: "http://localhost:8080/user/login",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                "username": username,
                "password": password
            }),
            success: function (data) {
                alert(data.message);
//                window.location.href = "http://182.254.152.99:8080/MyChat1/chat.jsp?username=" + username;
                 window.location.href = "http://localhost:8080/chat.jsp?username=" + username;
            }
        });
    }
</script>
    <input type="text" id="username" placeholder="用户名">
    <input type="password" id="password" placeholder="密码">
    <button onclick="doSend()">提交</button>
</body>
</html>
