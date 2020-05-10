<%--
  Created by IntelliJ IDEA.
  User: 吴所谓
  Date: 2020/5/8
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/policeuser/carRegister.do" method="post">
    车牌号：<input name="carnumber"></br>
    身份证号：<input name="identitycard"></br>
    身份证姓名：<input name="cardname"></br>
    电话号码：<input name="telephone"></br>
    车牌颜色：<input name="licenseplatecolor"></br>
    车颜色：<input name="carcolor"></br>
    车品牌：<input name="carbrand"></br>
    <input type="submit" value="注册" >
</form>
</body>
</html>
