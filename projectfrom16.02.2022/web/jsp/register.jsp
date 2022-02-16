<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2022
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Main Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center mt-10">
            <div class="col-5 mt-5 p-3">
                <form method="post" action="${pageContext.request.contextPath}/frontController" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" name="command" value="registerUser">
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
                    <label class="form-label">Gender</label>

                    <div class="form-check">
                        <input id="male" name="gender" type="radio" class="form-check-input" checked required>
                        <label class="form-check-label" for="male">Male</label>
                    </div>
                    <div class="form-check">
                        <input id="female" name="gender" type="radio" class="form-check-input" required>
                        <label class="form-check-label" for="female">Female</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <div class="form-text">Already have an account?
                        <a href="login.jsp">Sign up</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
