<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/1/18
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/blog/hello"> 测试成功</a>

    <form action="/blog/user" method="pos       t">
        <input type="text" name="name">
        <input type="text" name="sex">
        <input type="text" name="col">
        <input type="text" name="list[0]">
        <input type="text" name="map['take']">
        <input type="submit" value="提交">
    </form>
    <br>
    <a href="/blog/getcontext">aaaa</a>

    <br>

    <form action="/blog/testRequestParam">
        <input type="text" name="take">
        <input type="submit" value="提交">
    </form>

    <br>

    <form action="/blog/takeRequestBody" method="post">
        <input type="text" name="name">
        <input type="text" name="sex">
        <input type="text" name="col">
        <input type="text" name="list[0]">
        <input type="text" name="map['take']">
        <input type="submit" value="提交">
    </form>

    <br>
    <form action="/blog/takePathVariable/1">
        <input type="submit" value="提交">
    </form>
    <br>
    <form action="/blog/takeRequestHeader">
        <input type="submit" value="测试requestHeader">
    </form>

    <br>
    <form action="/blog/takecookievalue">
        <input type="submit" value="测试cookievalue">
    </form>


    <br>
    <form action="/blog/t">
        <input type="text" name="name">
        <input type="submit" value="提交">
    </form>


</body>
</html>
