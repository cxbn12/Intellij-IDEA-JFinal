<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/31 0031
  Time: 下午 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/Blog/blogadd" method="post">
    <p><label>标题：</label><input type="text" name="blog.title"></p>
    <p><label>内容：</label></p>
        <textarea style="width: 600px;height: 200px;" name="blog.content"></textarea>
        <input type="submit" value="提交">
    </form>

</body>
</html>
