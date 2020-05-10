<%--
  Created by IntelliJ IDEA.
  User: 吴所谓
  Date: 2020/4/22
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>

<img class="bgone" src="img/1.jpg" />
<img class="pic" src="img/a.png" />

<div class="table">
    <div class="wel">套牌车检测系统后台登录</div>

    <form action="/policeuser/login.do" method="post">
    <div class="error">
        <%if(session.getAttribute("errorinfo")!=null){%>
        错误：${sessionScope.errorinfo}</br>
        <%}%>
    </div>
    <div class="user">
        <div id="yonghu" style=""><img src="img/yhm.png" /></div>
        <input type="text" name="policename" placeholder="用户名" />
    </div>
    <div class="password">
        <div id="yonghu"><img src="img/mm.png" /></div>
        <input type="text" name="policepassword" placeholder="●●●●●●"/>
    </div>
    <input class="btn" type="submit" name="登录" value="登录" />
    </form>
</div>
</body>
</html>
