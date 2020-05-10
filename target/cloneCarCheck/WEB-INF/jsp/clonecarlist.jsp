<%--
  Created by IntelliJ IDEA.
  User: 吴所谓
  Date: 2020/4/23
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">
    <tr>
        <td>车辆识别表id</td>
        <td>图片地址</td>
        <td>处理人用户id</td>
        <td>套牌车状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${clonecarlist}" var="item">
        <tr>
            <td>${item.cardistinguishid}</td>
            <td>${item.picturelocaladdress}</td>
            <td>${item.policeuserid}</td>
            <td>${item.clonecarstatus}</td>
            <td><a href="http://localhost:8080/policeuser/updateClonecar.do?id=${item.id}&policeuserid=${sessionScope.policeuser.id}&clonecarstatus=2">是套牌车</a>||<a href="http://localhost:8080/policeuser/updateClonecar.do?id=${item.id}&clonecarstatus=0&policeuserid=${sessionScope.policeuser.id }">不是套牌车</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
