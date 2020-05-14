<%--
  Created by IntelliJ IDEA.
  User: alger
  Date: 30.04.2020
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<center>
    <h1>Пожалуйста, авторизуйтесь</h1>
</center>
<div align="center">

    <form action="/"  method="post">
        Имя Пользователя:<br>
        <input name="username" type="text"><br>
        Пароль:<br>
        <input name="password" type="password"><br>
        <input type="submit" value="Авторизироваться">
    </form>
</div>
</body>
</html>
