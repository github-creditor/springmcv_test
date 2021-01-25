<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/1/22
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>测试文件上传</h2>
<form action="/blog/filetest04" method="post" enctype="multipart/form-data">
    <input type="file" name="upload" >
    <input type="submit" value="上传">

</form>

</body>
</html>
