<%--
  Created by IntelliJ IDEA.
  User: Yahor_Kaltsou
  Date: 1/21/2022
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en_US'}" scope="session"/>
<fmt:setBundle basename="localization/localization" scope="session"/>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid" >
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="user.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="information.jsp">About gym</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="price.jsp">Price</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="team.jsp">Our team</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="contacts.jsp">Contacts</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <a class="btn" href="${pageContext.request.contextPath}/frontController?command=changeLanguage&lang=en">EN</a>
                    <a class="btn" href="${pageContext.request.contextPath}/frontController?command=changeLanguage&lang=ru">RU</a>
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>

