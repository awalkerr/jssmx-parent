<%--
  Created by IntelliJ IDEA.
  User: walker
  Date: 2018/8/21
  Time: 下午9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/user/register" method="post">
        用户名:<input type="text" name="username"><br/>
        密码:<input type="text" name="password"><br/>
        名字:<input type="text" name="name"><br/>
        邮箱:<input type="text" name="email"><br/>
        电话:<input type="text" name="phone"><br/>
        IP:<input type="text" name="ip"><br/>
        备注:<input type="text" name="remark"><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
