<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/homePage.css">
</head>
<body>
<%@include file="userHeader.jsp" %>
<div class="container">
    <div class="row">
        <h1 class="text-center" id="bestDay">Best day for train — today!</h1>
    </div>
    <div class="row">
        <div id="aboutGym">
            <h2><a href="information.jsp" title="About gym">About gym</a></h2>
            <p>Fitness life - это 200 кв.м. для качественных тренировок, новейшее оборудование, мотивирующая
                атмосфера и доступные цены. Тренажерный зал расположен недалеко от метро.
                Комфортная обстановка, душевые в каждой раздевалке, мощная вентиляция с рекуперацией.</p>
            <ul>
                <li>Большая кардиозона</li>
                <li>Свободные веса</li>
                <li>Силовое оборудование на все группы мышц</li>
                <li>Индивидуальные занятия с тренером</li>
            </ul>
        </div>
    </div>
    <div class="row" id="team">
        <div class="col-6">
            <h2><a href="team.jsp">Наша команда</a></h2>
            <p>состоит из сертифицированных тренеров, они помогут создать подходящую
                именно вам тренировочную
                программу и схему питания, поставят вам правильную технику выполнения упражнений, а также составят вам
                приятную компанию на каждой тренировке.</p>
        </div>
    </div>
    <div class="row" id="order">
            <h1 class="text-center">Приходите, мы вам всегда рады!<br><a href="price.jsp" title="Order">Order a
                subscription</a></h1>
    </div>
</div>
<%@include file="userFooter.jsp" %>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
