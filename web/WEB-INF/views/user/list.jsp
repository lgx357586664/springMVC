<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17 0017
  Time: 下午 4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>

    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="/user/delete/${user.id}">删除</a>
                <a href="/user/queryOne/${user.id}">修改</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="/user/toadd" >添加</a>
</body>
</html>
