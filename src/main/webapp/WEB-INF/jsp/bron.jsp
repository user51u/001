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
    <th>Описение</th>
    <th>Статус</th>

    <th>Статус</th>
    </thead>
    <c:forEach items="${allWorkplace}" var="workplace">
      <tr>
        <td>${workplace.id}</td>
        <td>${workplace.number}</td>
        <td>${workplace.detail}</td>
        <td>${workplace.status}</td>
        <td>
           <c:forEach items="${workplace.workplaceStatuses}" var="statusWorkplace">${statusWorkplace.name} </c:forEach>
        </td>

        <td>
          <form action="${pageContext.request.contextPath}/workplace" method="post">
            <input type="hidden" name="workplaceId" value="${workplace.id}"/>
            <input type="hidden" name="action" value="bron"/>
            <button type="submit">Бронировать</button>
          </form>

        </td>

      </tr>
    </c:forEach>
  </table>
  <a href="/">Главная</a>
</div>
</body>
</html>