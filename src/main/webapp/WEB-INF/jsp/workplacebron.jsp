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
<label for="start">Дата начала брони:</label>

<input type="date" id="start" name="trip-start"
       value="2018-07-22"
       min="2021-06-01" >

        <label for="appt">Время начала брони:</label>

                     <input type="time" id="appt" name="appt"
                            min="09:00" max="18:00" required> <br><br>


       <label for="start">Дата конца брони: </label>

       <input type="date" id="start" name="trip-start"
              value="2018-07-22"
              min="2021-06-01" >


              <label for="appt">Время конца брони:</label>

              <input type="time" id="appt" name="appt"
                     min="09:00" max="18:00" required> <br><br>






<div>
  <table>
    <thead>
    <th>ID</th>
    <th>Номер</th>
    <th>Описение</th>
    <th>Старт</th>

    <th>Стоп</th>
    </thead>
    <c:forEach items="${allWorkplaceBron}" var="workplace">
      <tr>
        <td>${workplace.id}</td>
        <td>${workplace.number}</td>
        <td>${workplace.detail}</td>
        <td>${workplace.date_start}</td>
        <td>${workplace.date_stop}</td>
        <td>

        </td>

        <td>


        </td>
<td><form action="${pageContext.request.contextPath}/workplacebron" method="post">
                <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                <input type="hidden" name="action" value="bron5"/>
                <button type="submit">Просмотр брони</button>
              </form></td>

      </tr>
    </c:forEach>
  </table>
  <a href="/">Главная</a>
</div>
</body>
</html>