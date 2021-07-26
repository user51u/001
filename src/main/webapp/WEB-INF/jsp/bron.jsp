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
        <input type="date" id="start" name="start"  >


        <script>
           //document.getElementById('start').valueAsDate = new Date();
        </script


         <label for="appt">Время начала брони:</label>
         <input type="time" id="appt" name="startTime"
            min="00:00" max="24:00" >

         <label for="appt">Время конца брони:</label>
         <input type="time" id="appt" name="stopTime"
            min="00:00" max="24:00" > <br><br>
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
                     <td>${workplace.status}</td>
                     <td>
                        <c:forEach items="${workplace.workplaceStatuses}" var="statusWorkplace">${statusWorkplace.name}    </c:forEach>
                     </td>
                     <td>



      <form action="${pageContext.request.contextPath}/bron" method="post">
      <input type="hidden" name="workplaceId" value="${workplace.id}"/>
      <input type="hidden" name="action" value="setZanato"/>
      <button type="submit">Занято</button>
      </form>


      <form action="${pageContext.request.contextPath}/bron" method="post">
      <input type="hidden" name="workplaceId" value="${workplace.id}"/>
      <input type="hidden" name="action" value="setVybrano"/>
      <button type="submit">Выбрано</button>
      </form>

      <form action="${pageContext.request.contextPath}/bron" method="post">
      <input type="hidden" name="workplaceId" value="${workplace.id}"/>
      <input type="hidden" name="action" value="setVybrano"/>
      <button type="submit">Выбрано</button>
      </form>



      <form action="${pageContext.request.contextPath}/bron" method="post">
      <input type="hidden" name="workplaceId" value="${workplace.id}"/>
      <input type="hidden" name="action" value="setNedostupno"/>
      <button type="submit">Недоступно</button>
      </form>



      </td>
      <td>

      <form action="${pageContext.request.contextPath}/bron" method="post">
      <input type="hidden" name="workplaceId" value="${workplace.id}"/>
      <input type="hidden" id="start1" name="start1" value="11111" />
      <input type="hidden" name="action" value="zabron"/>
      <button id= "zabron" type="submit">Забронировать</button>
      </form>



 <script>
   document.getElementById('zabron').onclick = function changeContent() {
   document.getElementById('start1').value =  document.getElementById('start').value;
}
  </script

      <form action="${pageContext.request.contextPath}/bron" method="post">
      <input type="hidden" name="workplaceId" value="${workplace.id}"/>
      <input type="hidden" name="action" value="listBrone"/>
      <button type="submit">Просмотр брони</button>
      </form>





      </td>
      </tr>
      </c:forEach>
      </table>
      <a href="/">Главная</a>
      </div>

      </div>
      </form>




   </body>
</html>