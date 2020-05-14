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
    <title>Менеджер пользователей</title>
</head>
<body>
<center>
    <h1>Менеджер пользователей</h1>
    <h2>
        <a href="new">Добавить нового сотрудника</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">Список всех сотрудников</a>

    </h2>
</center>
<div align="center">
    <c:if test="${user != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Редактировать
                        </c:if>
                        <c:if test="${user == null}">
                            Добавить нового сотрудника
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                </c:if>
                <tr>
                    <th>Имя сотрудника: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${user.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${user.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Пароль: </th>
                    <td>
                        <input type="password" name="password" size="15"
                               value="<c:out value='${user.password}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Категория: </th>
                    <td>
                        <input type="text" name="role" size="15"
                               value="<c:out value='${user.role}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Сохранить" />
                    </td>
                </tr>
            </table>
        </form>
            <button type="button"><a href="logout">Выход</a></button>
</div>
</body>
</html>
