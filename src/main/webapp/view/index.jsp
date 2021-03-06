<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Image Gallery</title>
</head>
<body>
<h1 align="center">Welcome to Image Gallery!!!</h1>
<form method="post">
    <table border="1px" align="center" width="450">
        <tr>
            <th width="150">
                <a href="?IsortBy=type" title="Press to sort">Type of image</a></th>
            <th width="150">
                <a href="?IsortBy=size" title="Press to sort">Size in px</a></th>
            <th width="200">
                <a href="?IsortBy=date" title="Press to sort">Date added</a></th>
        </tr>
    </table>
</form>
<form method="get" action="create">
    <c:forEach var="image" items="${requestScope.images}">
        <table border="1px" align="center" width="450">
            <tr>
                <td width="150">
                    <input type="checkbox" name="choosedImage" value="${image.id}">
                    <c:out value="${image.type}"/>
                </td>
                <td width="150"><c:out value="${image.size}"/></td>
                <td width="200"><c:out value="${image.addingDate}"/></td>
            </tr>
        </table>
    </c:forEach>
    <div align="center" style="margin: 20px "><input type="submit" name="Create movie"></div>
</form>
<hr/>
<div style="float: left; margin-left: 50px; margin-top: 20px"
">
<form method="post">
    <table border="1">
        <tr>
            <td width="100">Type</td>
            <td>
                <select name="type" style="width: 180px">
                    <option value="vector">Vector</option>
                    <option value="bitmap">Bitmap</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="100">Size</td>
            <td><input type="number" name="size"></td>
        </tr>
    </table>
    <input type="submit" value="Add image">
</form>
</div>
<div style="float: right; margin-right: 50px; margin-top: 20px">
    <form action="/" method="get">
        <b>Size > </b><input type="number" name="sizeFilterMore">
        <b>Size < </b><input type="number" name="sizeFilterLess">
        <input type="submit" value="OK">
    </form>
</div>
</body>
</html>
