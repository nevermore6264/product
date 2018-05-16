<%--
  Created by IntelliJ IDEA.
  User: dangkhoa
  Date: 11/05/2018
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
        <h2>Product Manager</h2>
        <form method="get" action="/product?action=save">
            Id: <input type="text" name="idd"><br>
            Code: <input type="text" name="code"><br>
            Name: <input type="text" name="name"><br>
            Price: <input type="text" name="price"><br>
            Category <select name="category">
            <c:forEach items="${Categorys}" var="category">
            <option value="${category.getId()}">${category.getName()}</option>
            </c:forEach>
        </select>
            <button>send</button>
        </form>

        <br>
      <table border="1">
          <th>Id</th>
          <th>Code</th>
          <th>Name</th>
          <th>Price</th>
          <th>Category</th>
          <th>Edit</th>
          <th>Delete</th>
        <c:forEach var="pro" items="${requestScope['list']}">
            <tr>
                <td>${pro.getId()}</td>
                <td>${pro.getCode()}</td>
                <td><a href="/product?action=info&id=${pro.getId()}">${pro.getName()}</a></td>
                <td>${pro.getPrice()}</td>
                <td>${pro.getCategory().getName()}</td>
                <td>Edit</td>
                <td><a href="/product?action=delete&id=${pro.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
      </table>
  </body>
</html>
