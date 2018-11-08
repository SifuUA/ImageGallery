<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 11/8/18
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form method="post" action="/"></form>--%>
<%--<label>--%>
<%--<select name="types">--%>
<%--<option value="vector">Vector image</option>--%>
<%--<option value="bitmap">Bitmap image</option>--%>
<%--</select>--%>
<%--</label>--%>

<h2>Создание нового пользователя</h2><br/>

<form method="post" action="">
    Choose type <label>
    <select name="type">
        <option value="vector">Vector image</option>
        <option value="bitmap">Bitmap image</option>
    </select>
</label>
    <br/>
    Image size<label><input type="number" name="size"></label><br/>
    <input type="submit" value="Ok" name="Ok">
</form>
</body>
</html>
