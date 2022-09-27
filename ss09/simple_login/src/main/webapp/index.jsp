<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 26/09/2022
  Time: 1:45 CH
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<style>
  .login {
    height:180px; width:230px;
    margin:0;
    padding:10px;
    border:1px #CCC solid;
  }
  .login input {
    padding:5px; margin:5px
  }
</style>
<body>
<form method="get" action="/login">
  <div class="login">
    <h2>Login</h2>
    <input id = txt-username type="text" name="username" placeholder="username" />
    <input type="password" name="password" placeholder="password" />
    <input type="submit" value="Sign in"/>
  </div>
</form>
</body>
</html>
