<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Бронирование рабочего места</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<!--<label id="text">text </label>-->

<form action="${pageContext.request.contextPath}/bron" method="post">
    <label for="start">Дата начала брони:</label>
    <input type="date" required=true id="start" name="trip-start"
           value="2018-07-22"
           min="2021-06-01">

    <label >Время начала брони:</label>

    <input type="time" required=true id="startTime"> <br><br>


    <label for="stop">Дата конца брони: </label>

    <input type="date" required=true id="stop" name="trip-start"
           min="2021-06-01">


    <label for="stopTime">Время конца брони:</label>

    <input type="time" required=true id="stopTime"> <br><br>
    <input type="hidden" name="workplaceId" value="${workplace.id}"/>
    <input type="hidden" name="action" value="bronCheckDate"/>
    <input type="hidden" id="startTmp" name="start" value="1234567890"/>
    <input type="hidden" id="stopTmp" name="stop" value="1234567890"/>
    <input type="hidden" id="param" name="param" value="1234567890"/>
    <button id="buttonCheck" onclick="checkDate()" type="submit">Проверить</button>
</form>


<p id="test"></p>


<script>

        function runOnLoad() {
        var a = new Date();
        var year = a.toLocaleString().substring(6, 10);
        var month = a.toLocaleString().substring(3, 5);
        var day = a.toLocaleString().substring(0, 2);
        var a1 = year + "-"+ month +"-"+ day;
        document.getElementById('start').value= a1;
        document.getElementById('start').min= a1;

        //document.getElementById("text").innerHTML ="Page location is " + window.location.href;
        var url = new URL(window.location.href);
       var start1=url.searchParams.get("start");
       var param=url.searchParams.get("param");
      // alert(param);
    //    document.getElementById("text").innerHTML=url.searchParams.get("start");
      alert(start1);

        if(start1!=null)
{
         var dateTime1 = start1.split('T');
       //  alert(dateTime1);
        //document.getElementById("text").innerHTML=dateTime1;
        document.getElementById('start').value= dateTime1[0];
        document.getElementById('startTime').value= dateTime1[1];
    alert("2");
        var stop1=url.searchParams.get("stop");
        var dateTime2 = stop1.split('T');
        document.getElementById('stop').value= dateTime2[0];
        document.getElementById('stopTime').value= dateTime2[1];
 }
        alert(param);

        if (param==="runOnLoad"||param===null)
        {

        }
        else
        {
        alert("3");
        document.getElementById('param').value= "runOnLoad";
        document.getElementById("buttonCheck").click();
        }

        }



  function checkDate() {
        var x=document.getElementById('start').value+ "T" +document.getElementById('startTime').value ;
           var y=document.getElementById('stop').value+ "T" +document.getElementById('stopTime').value ;
        var x1 = new Date(x);
        var y1 = new Date(y);
        var dt = y1 - x1;
        var g =    document.getElementById("start").value;
        document.getElementById('test').innerHTML= g;
        if(dt<0){
         alert( "Дата/время конца брони должно быть позже начала брони" );
}
else
{

          document.getElementById('startTmp').value=document.getElementById('start').value+ "T" +document.getElementById('startTime').value ;
          document.getElementById('stopTmp').value=document.getElementById('stop').value+ "T" +document.getElementById('stopTime').value ;


}

        }



function color(){
   var x = document.getElementsByTagName('td');
   for(i=0;i<x.length;i++) {
     x[i].style.backgroundColor ="blue";
   }
}



function color1(st){

if (st===0){

  return "#FFFFFF";
}

if (st===1){

  return "#FF0000";
}

if (st===2){

  return "#00FF00";
}

if (st===3){

  return "#0000FF";
}

if (st===4){

  return "#00FFFF";
}
 return "#FFFFFF";

}




function getStatus(st){
alert ("status "+st)
if (st===0){
  return "неопределен";  //неопределен
}
if (st===1){
  return "занято";  //занято
}

if (st===2){
 //alert(st);
  return "свободно";  //свободно
}

if (st===3){

  return "выбрано";  //выбрано
}

if (st===4){
   return "недоступно";  //недоступно
}


 return "неопределен";
}


function getDisabled(st){

if (st===0){
  return true;  //неопределен
}
if (st===1){
  return true;  //занято
}

if (st===2){
 //alert(st);
  return false;  //свободно
}

if (st===3){

  return true;  //выбрано
}

if (st===4){

   return true;  //недоступно
}
}



function clearit(){
   var x = document.getElementsByTagName('td');
   for(i=0;i<x.length;i++) {
     x[i].style.backgroundColor = "";
   }
}











</script>


<div>
    <table>
        <thead>
        <th>ID</th>
        <th>№ рабочего места</th>
        <th>Описание</th>


        <th>Статус</th>
        </thead>
        <c:forEach items="${allWorkplace}" var="workplace">
            <tr>
                <td>${workplace.id}</td>
                <td>${workplace.number}</td>
                <td>${workplace.detail}</td>
            <!--    <td>${workplace.status}</td>


                <td id="${workplace.id}">${workplace.status}</td>-->

                <script>
                //alert( color1());
                document.getElementById(${workplace.id}).style.backgroundColor=color1(${workplace.status});

                </script>


                <td id="status${workplace.id}">${workplace.status}</td>

                <script>
                alert("color "+ color1());
                document.getElementById("status${workplace.id}").style.backgroundColor=color1(${workplace.status});
                document.getElementById("status${workplace.id}").textContent=getStatus(${workplace.status});
                </script>

                <!--   <td>
                       <c:forEach items="${workplace.workplaceStatuses}" var="statusWorkplace">${statusWorkplace.name}
                       </c:forEach>
                   </td>-->

                <!--  <td>
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


                  </td>-->
                <td>
                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" name="action" value="bron5"/>
                        <button type="submit">Просмотр брони</button>
                    </form>


                    <form action="${pageContext.request.contextPath}/bron" method="post">
                        <input type="hidden" name="workplaceId" value="${workplace.id}"/>
                        <input type="hidden" id="startTmp${workplace.id}" name="start" value="1234567890"/>
                        <input type="hidden" id="stopTmp${workplace.id}" name="stop" value="1234567890"/>
                        <input type="hidden" name="action" value="bron6"/>
                        <button id="br1${workplace.id}" onclick="setDate(${workplace.id})" type="submit">
                            Забронировать
                        </button>
                    </form>

                </td>


                <script>
                 //   alert( "color1()");
                    var t = document.createTextNode("test content");
                  //  document.getElementById("br1${workplace.id}").textContent = 'Show filter1';
                    document.getElementById("br1${workplace.id}").disabled =getDisabled(${workplace.status});



                </script>

            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
</div>

<script>
         function setDate(id) {
          document.getElementById('startTmp'+id).value=document.getElementById('start').value+ "T" +document.getElementById('startTime').value ;
          document.getElementById('stopTmp'+id).value=document.getElementById('stop').value+ "T" +document.getElementById('stopTime').value ;
       //   alert( document.getElementById('startTmp'+id).value +" "+ document.getElementById('stopTmp'+id).value );
        }


</script>

<body
        onload="runOnLoad();">
</body>


</html>