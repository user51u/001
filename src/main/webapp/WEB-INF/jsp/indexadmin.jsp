<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Главная</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
  <h3>${pageContext.request.userPrincipal.name}</h3>

  <h4><a href="/regwor">Регистрация workplace</a></h4>
  <h4><a href="/admin">Пользователи (только админ)</a></h4>
  <h4><a href="/workplace">Рабочие места</a></h4>
</div>
</body>
</html>