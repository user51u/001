<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>


<div>
  <table>
    <thead>
    <th>ID</th>
    <th>Номер</th>
    <th>Пользователь</th>
    <th>Описение</th>
    <th>Старт</th>
    <th>Старт time</th>
    <th>Стоп time</th>


    </thead>
    <c:forEach items="${allWorkplaceBron}" var="workplacebron">
      <tr>
        <td>${workplacebron.id}</td>
        <td>${workplacebron.number}</td>
        <td>${workplacebron.id_user}</td>
        <td>${workplacebron.detail}</td>
        <td>${workplacebron.date_start3}</td>
        <td>${workplacebron.time_start}</td>
        <td>${workplacebron.time_stop}</td>

        <td>

        </td>

        <td>

<td><form action="${pageContext.request.contextPath}/workplacebron" method="post">
                <input type="hidden" name="workplaceId" value="${workplacebron.number}"/>
                <input type="hidden" name="bronId" value="${workplacebron.id}"/>
                <input type="hidden" name="action" value="delete"/>
                <button type="submit">Удалить бронь</button>
              </form>
        </td>

      </tr>
    </c:forEach>
  </table>
  <a href="/">Главная</a>
</div>
</body>
</html>