<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09.02.2022
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/order.css">
</head>
<body>
<%@include file="userHeader.jsp" %>
<div class="container">
    <div class="py-5 text-center">
        <h2>Your order</h2>
    </div>
    <div class="row">
        <div class="col-3">
            <ul class="list-group mb-3">
                <li class="list-group-item d-flex justify-content-between center">
                    <h5 class="my-0">Subscription for ${param.season}</h5>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-sm">
                    <h5 class="text-muted">Price</h5>
                    <strong>
                        <c:if test="${'month' eq param.season}">
                            <p>70</p>
                        </c:if>
                        <c:if test="${'six month' eq param.season}">
                            <p>380</p>
                        </c:if>
                        <c:if test="${'year' eq param.season}">
                            <p>600</p>
                        </c:if>
                        <c:if test="${'12 trainings' eq param.season}">
                            <p>60</p>
                        </c:if>
                        <c:if test="${'24 trainings' eq param.season}">
                            <p>110</p>
                        </c:if>
                        <c:if test="${'36 trainings' eq param.season}">
                            <p>160</p>
                        </c:if>
                    </strong>
                </li>
            </ul>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/frontController"
              enctype="application/x-www-form-urlencoded">
            <input type="hidden" name="command" value="createOrder">
            <h4 class="mb-3 text-center">Purpose</h4>
            <div class="my-3">
                <div class="form-check">
                    <input id="muscle" name="purpose" type="radio" class="form-check-input" checked required>
                    <label class="form-check-label" for="muscle">Muscle</label>
                </div>
                <div class="form-check">
                    <input id="fatBurning" name="purpose" type="radio" class="form-check-input" required>
                    <label class="form-check-label" for="fatBurning">Fat burning</label>
                </div>
            </div>
        <div class="my-3">
            <hr class="my-4">
                <h4 class="mb-3 text-center">Payment</h4>
                <div class="my-3">
                    <div class="form-check">
                        <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked required>
                        <label class="form-check-label" for="credit">Credit card</label>
                    </div>
                    <div class="form-check">
                        <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required>
                        <label class="form-check-label" for="debit">Debit card</label>
                    </div>
                    <div class="form-check">
                        <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required>
                        <label class="form-check-label" for="paypal">PayPal</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label for="cc-name" class="form-label">Name on card</label>
                        <input type="text" class="form-control" id="cc-name" placeholder="" required>
                        <small class="text-muted">Full name as displayed on card</small>
                        <div class="invalid-feedback">
                            Name on card is required
                        </div>
                    </div>
                </div>
                <div class="row my-3">
                    <div class="col-md-6">
                        <label for="cc-number" class="form-label">Credit card number</label>
                        <input type="text" class="form-control" id="cc-number" placeholder="" required>
                        <div class="invalid-feedback">
                            Credit card number is required
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label for="cc-expiration" class="form-label">Expiration</label>
                        <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
                        <div class="invalid-feedback">
                            Expiration date required
                        </div>
                    </div>
                </div>
                <div class="row my-3">
                    <div class="col-md-6">
                        <label for="cc-cvv" class="form-label">CVV</label>
                        <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                        <div class="invalid-feedback">
                            Security code required
                        </div>
                    </div>
                </div>

                <hr class="my-4">
                <div class="text-center">
                    <button class="w-50 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="userFooter.jsp" %>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
