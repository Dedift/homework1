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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/team.css">
</head>
<body>
<%@include file="userHeader.jsp" %>
<div class="container">
    <div class="row">
        <h2 class="text-center"><a href="team.jsp">Наша команда</a></h2>
        <h4>состоит из сертифицированных тренеров, они помогут создать подходящую
            именно вам тренировочную
            программу и схему питания, поставят вам правильную технику выполнения упражнений, а также составят вам
            приятную компанию на каждой тренировке.</h4>
    </div>
    <hr class="my-4">

</div>
<%@include file="userFooter.jsp" %>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>