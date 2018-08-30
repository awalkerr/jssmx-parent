<%--
  Created by IntelliJ IDEA.
  User: walker
  Date: 2018/8/22
  Time: 上午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/doLogin" method="post">
    用户名:<input type="text" name="username"><br/>
    密码:<input type="text" name="password"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
