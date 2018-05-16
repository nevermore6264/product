<%--
  Created by IntelliJ IDEA.
  User: dangkhoa
  Date: 13/05/2018
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <h2>Product Info</h2>
    <a href="/index">back</a><br>
    <br>
    Id: ${product.getId()}<br>
    Code: ${product.getCode()}<br>
    Name: ${product.getName()}<br>
    Price: ${product.getPrice()}<br>
    Category: ${product.getCategory().getName()}
</body>
</html>
