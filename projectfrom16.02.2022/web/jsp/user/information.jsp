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
    <title>Information</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/information.css">
</head>
<body>
<%@include file="userHeader.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-8" id="text">
            <h2 class="text-center"><a href="information.jsp" title="About gym" id="aboutGym">About gym</a></h2>
            <p>Fitness life - это 200 кв.м. для качественных тренировок, новейшее оборудование, мотивирующая атмосфера
            и доступные цены. Тренажерный зал расположен недалеко от метро.
                Комфортная обстановка, душевые в каждой раздевалке, мощная вентиляция с рекуперацией.</p>
            <ul>
                <li>Большая кардиозона</li>
                <li>Свободные веса</li>
                <li>Силовое оборудование на все группы мышц</li>
                <li>Индивидуальные занятия с тренером</li>
            </ul>
        </div>
        <div class="col-4">
            <h5>Время работы зала</h5>
            <ul>
                <li>ПН-ПТ 08.00-22.00</li>
                <li>СБ-ВС 08.00-15.00</li>
            </ul>
        </div>
    </div>
    <img src="/resources/images/IMG_5369-1024x587.jpg" class="foto">
    <div class="row">
        <div class="col-8">
            <p>Мы уверены, что важной составляющей эффективной тренировки является атмосфера места, ГДЕ вы тренируетесь.
            Помимо
            основных моментов, таких как правильно подобранная программа, внимательный тренер и хорошие тренажеры,
            именно
            атмосфера делает занятия интересными, заряжает вас энергией, поднимает настроение и добавляет каждой
            тренировке
                драйва. Эта идея легла в основу дизайна интерьера зала Rock GYM.</p>
        </div>
        <img src="/resources/images/IMG_5373-768x487.jpg" class="foto">
    </div>
    <div class="row">
        <div class="col-8">
            <p>Дизайн разработан таким образом, чтобы настраивать на интенсивные занятия и работу над собой, мотивировать,
            создавать правильное настроение в каждой зоне, у каждого клиента. Для оформления были выбраны три цвета:
            белый, желтый и черный.</p>
        </div>
        <img src="/resources/images/Fitness-life3.jpg" class="foto">
        <div class="col-8">
            <ul>
                <li>Белый делает помещение светлее, свободнее, является хорошей базой.</li>
                <li>Сочетание черного и желтого мотивирует к действию — «отдыхать нет времени».</li>
                <li>Крупные стилизованные изображения и фразы добавляют оригинальности и помогают сконцентрироваться на
                    результате.
                </li>
            </ul>
        </div>
    </div>
</div>
<%@include file="userFooter.jsp" %>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>