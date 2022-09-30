<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 30/09/2022
  Time: 2:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h3>Thêm sản phẩm mới</h3>
<c:if test="${mess!=null}">
    <p style="color: green">${mess}</p>
</c:if>
<form method="post">
    <pre>Tên sản phẩm:  <input type="text" name="name"></pre>
    <pre>Giá :          <input type="text" name="price"></pre>
    <pre>Mô tả:         <input type="text" name="describe"></pre>
    <pre>Nhà sản xuất:  <input type="text" name="producer"></pre>
    <pre>               <button style="background-color: #67dc6a">Lưu</button></pre>
</form>
<a href="/product">< Quay lại trang Danh sách sản phẩm</a>
</body>
</html>
