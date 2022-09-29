<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 29/09/2022
  Time: 3:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<h1 style="align-content: center">Danh sách khách hàng</h1>
<table class="table table-primary">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" >
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getDateOfBirth()}</td>
            <td>${customer.getAddress()}</td>
            <td>
                <img style="width: 70px ; height: 50px" src="${customer.getPicture()}" >
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
