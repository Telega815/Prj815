<%@ page import="static ru.test815.db.Main.getId" %><%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 04.02.2018
  Time: 20:37
  To change this template use UserFile | Settings | UserFile Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <style>
        <%@include file="Style.css"%>
    </style>
    <!--<link rel="stylesheet" type="text/css" href="Style.css" />-->
    <meta charset="utf-8">
    <title>1page</title>
</head>

<body>
<div class="downloadBlock">
    <form enctype="multipart/form-data" method="post">
        <p><input size="70" class="textField" placeholder="Введите текст" name="text" value="123456789">
            <input type="file" name="f" multiple>
            <input type="submit" value="загрузить на серв"></p>
    </form>
</div>
</body>
</html>
