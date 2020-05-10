<%--
  Created by IntelliJ IDEA.
  User: 吴所谓
  Date: 2020/4/22
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%if(session.getAttribute("policeuser")!=null){%>
<a href="/policeuser/selectByclonecarstatus.do"><input type="button" value="可能是套牌车列表" ></a>
<a href="/policeuser/toCarRegister.do"><input type="button" value="车辆信息注册登记" ></a>
<%}else {
    response.sendRedirect("http://localhost:8080");
}%>
</body>
</html>
