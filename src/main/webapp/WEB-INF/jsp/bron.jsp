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

    <form action="${pageContext.request.contextPath}/bron" method="post">




        <label>Дата начала брони:</label>
        <input type="date" id="start"  name="start"  required>


         <label for="appt">Время начала брони:</label>
         <input type="time" id="startTime" name="startTime"
            min="00:00" max="24:00"  required>

         <label for="appt">Время конца брони:</label>
         <input type="time" id="stopTime" name="stopTime"
            min="00:00" max="24:00" required >
             <button id= "проверить" type="submit">Проверить</button>

              </form>


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
      <input type="hidden" name="action" value="setSvobodno"/>
      <button type="submit">Свободно</button>
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
      <input type="hidden" name="action" value="listBrone"/>
      <button type="submit">Просмотр брони</button>
      </form>




    <form action="${pageContext.request.contextPath}/bron" method="post">
      <input type="hidden" name="workplaceId" value="${workplace.id}"/>

      <input type="hidden" id="start1"  name="start"  required>

      <input type="hidden" id="startTime1" name="startTime" value="02" />
      <input type="hidden" id="stopTime1" name="stopTime" value="03" />
      <input type="hidden" id="action" name="action" value="zabron"/>
      <button id= "zabron" type="submit">Забронировать</button>
      </form>




   <script>
   document.getElementById('zabron111').onclick = function changeContent() {

   if ( document.getElementById('start').value === "") {
     document.getElementById('action').value="error"
    alert("Введите дату");
   }
    else
       {
        document.getElementById('start1').value =  document.getElementById('start').value;


            if ( document.getElementById('startTime').value === "")
            {
             document.getElementById('action').value="error"
            alert("Введите время начала аренды");
            }
            else
            {
            document.getElementById('startTime1').value =  document.getElementById('startTime').value;

               if ( document.getElementById('stopTime').value === "")
                {
                 document.getElementById('action').value="error"
                alert("Введите время конца аренды");
                }
                else
                {
                document.getElementById('stopTime1').value =  document.getElementById('stopTime').value;
                }


        }
   }
   }
   </script







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