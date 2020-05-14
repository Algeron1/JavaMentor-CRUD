<%--
  Created by IntelliJ IDEA.
  User: alger
  Date: 28.04.2020
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Данные о пользователе</title>
</head>
<body>
<center>
    <h1>Данные о пользователе</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Залогинился</h2></caption>
        <tr>
            <th>Имя</th>
            <th>Email</th>
            <th>Пароль</th>
            <th>Категория</th>
        </tr>
        <%--@elvariable id="listUser" type="java.util.List"--%>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="информация скрыта" /></td>
                <td><c:out value="${user.role}" /></td>
            </tr>
        </c:forEach>
    </table>
    <button type="button"><a href="logout">Выход</a></button>
</div>
</body>
</html>
