<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Бронирование рабочего места</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<label for="start">Дата начала брони:</label>

<input type="date" id="start" name="trip-start"
       value="2018-07-22"
       min="2021-06-01">

<label for="appt">Время начала брони:</label>

<input type="time" id="startTime"> <br><br>


<label for="stop">Дата конца брони: </label>

<input type="date" id="stop" name="trip-start"
       value="2018-07-22"
       min="2021-06-01">


<label for="stopTime">Время конца брони:</label>

<input type="time" id="stopTime"> <br><br>


<button ondblclick="My_Date()">Return Date</button>

<p id="test"></p>


<script>

function color(){
   var x = document.getElementsByTagName('td');
   for(i=0;i<x.length;i++) {
     x[i].style.backgroundColor ="blue";
   }
}
function color1(st){

if (st===1){

  return "#FF0000"
}

if (st===2){

  return "#00FF00"
}

if (st===3){

  return "#0000FF"
}

if (st===4){

  return "#00FFFF"
}





}
function clearit(){
   var x = document.getElementsByTagName('td');
   for(i=0;i<x.length;i++) {
     x[i].style.backgroundColor = "";
   }
}






        function My_Date() {
        var g =    document.getElementById("start").value;
        document.getElementById('test').innerHTML= g;
        }



</script>


<div>
    <table>
        <thead>
        <th>ID</th>
        <th>№ рабочего места</th>
        <th>Описание</th>
        <th>Статус</th>

        <th>Статус</th>
        </thead>
        <c:forEach items="${allWorkplace}" var="workplace">
            <tr>
                <td>${workplace.id}</td>
                <td>${workplace.number}</td>
                <td>${workplace.detail}</td>
                <td>${workplace.status}</td>



                <td id="${workplace.id}">${workplace.status}</td>

                <script>
                //alert( color1());
                document.getElementById(${workplace.id}).style.backgroundColor=color1(${workplace.status});


                </script>
                <td>
                    <c:forEach items="${workplace.workplaceStatuses}" var="statusWorkplace">${statusWorkplace.name}
                    </c:forEach>
                </td>

                <td>
                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" name="action" value="bron1"/>
                        <button type="submit">Занято</button>
                    </form>


                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" name="action" value="bron2"/>
                        <button type="submit">Свободно</button>
                    </form>


                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" name="action" value="bron3"/>
                        <button type="submit">Выбрано</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" name="action" value="bron4"/>
                        <button type="submit">Недоступно</button>
                    </form>


                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" name="action" value="bron5"/>
                        <button type="submit">Просмотр брони</button>
                    </form>


                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" id="stopTmp" name="stop" value="1234567890"/>
                        <input type="hidden" id="startTmp" name="start" value="1234567890"/>

                        <input type="hidden" name="action" value="bron6"/>
                        <button id="br1" onclick="My_Date1()" type="submit">Забронировать</button>
                    </form>


                </td>

            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
</div>

<script>




         function My_Date1() {

          document.getElementById('startTmp').value=document.getElementById('start').value+ "-" +document.getElementById('startTime').value ;
          document.getElementById('stopTmp').value=document.getElementById('stop').value+ "-" +document.getElementById('stopTime').value ;
          alert( document.getElementById('stopTmp').value );
        }







</script>


</body>


</html>