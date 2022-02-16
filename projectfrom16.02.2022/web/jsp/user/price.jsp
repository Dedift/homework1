<%--
  Created by IntelliJ IDEA.
  User: Yahor_Kaltsou
  Date: 1/21/2022
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Main Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/price.css">
</head>
<body>
<%@include file="userHeader.jsp"%>
<div class="container">
    <div class="row">
        <h1>Цены</h1>
        <ul>
            <li><a href="order.jsp?season=12 trainings">Абонемент на 12 занятий - 60</a></li>
            <li><a href="order.jsp?season=24 trainings">Абонемент на 24 занятий - 110</a></li>
            <li><a href="order.jsp?season=36 trainings">Абонемент на 36 занятий - 160</a></li>
            <li><a href="order.jsp?season=month">Абонемент на месяц - 70</a></li>
            <li><a href="order.jsp?season=six month">Абонемент на полгода - 380</a></li>
            <li><a href="order.jsp?season=year">Абонемент на год - 600</a></li>
        </ul>
    </div>
    <div class="row">
        <h1>Скидки</h1>
        <ul>
            <li>Скидки постоянным клиентам</li>
            <li>Скидка корпоративным клиентам - 5%</li>
        </ul>
    </div>
</div>
            <%@include file="userFooter.jsp"%>
            <script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>