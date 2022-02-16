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
<%@include file="userHeader.jsp"%>
<div class="body-content-wrapper">
    <div class="page-header clearfix">
        <div class="tg-container">
            <h2 class="entry-title">Контакты</h2>
        </div>
    </div>
    <div id="content" class="site-content">
        <main id="main" class="clearfix right_sidebar">
            <div class="tg-container">
                <div id="primary">
                    <div id="content-2">
            <%@include file="userFooter.jsp"%>
            <script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>