<%--
  Created by IntelliJ IDEA.
  User: Yahor_Kaltsou
  Date: 1/14/2022
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-5 mt-5 p-3">
            <form method="post" action="${pageContext.request.contextPath}/frontController"
                  enctype="application/x-www-form-urlencoded">
                <input type="hidden" name="command" value="loginUser">
                <div class="mb-3">
                    <label for="exampleInputEmail" class="form-label">Email address</label>
                    <input name="email" type="email" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" required>
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <div class="form-text">Don’t have an account?
                    <a href="register.jsp">Sign up</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>

