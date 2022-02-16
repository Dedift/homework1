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
</head>
<body>
<%@include file="adminHeader.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-6">
            <h3>Hello ${sessionScope.user.fullName}</h3>
                <h2>You have ${sessionScope.user.role} role!</h2>
        </div>
    </div>
</div>
<%@include file="adminFooter.jsp"%>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
