<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17 0017
  Time: 下午 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/add">
    <table>
        <c:if test="${user.id!=null}">
        <tr>
            <td>id</td>
            <td><input type="text" name="id" readonly value="${user.id}"></td>
        </tr>
        </c:if>
        <tr>
            <td>username</td>
            <td><input type="text" name="username" value="${user.username}"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="保存"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
