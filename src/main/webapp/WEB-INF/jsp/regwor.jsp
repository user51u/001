<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Регистрация рабочего места</title>
</head>

<body>
<div>
  <form:form method="POST" modelAttribute="userForm">
    <h2>Регистрация рабочего места</h2>
    <input name="number" type="text" placeholder="number"  autofocus="true"/>
    <input name="detail" type="text" placeholder="detail"/>
    <button type="submit">Зарегистрировать</button>
  </form:form>



 <a href="/indexadmin">Назад</a>
</div>
</body>
</html>