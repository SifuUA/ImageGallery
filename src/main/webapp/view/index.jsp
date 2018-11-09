<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Image Gallery</title>
</head>
<body>
<h1 align="center">Welcome to Image Gallery!!!</h1>
<table border="1px" align="center" width="400">
    <tr>
        <th width="150"><a href="/" title="Press to sort">Type of image</a></th>
        <th width="100"><a href="/" title="Press to sort">Size in px</a></th>
        <th width="150"><a href="/" title="Press to sort">Date added</a></th>
    </tr>
</table>
<c:forEach var="image" items="${requestScope.images}">
    <table border="1px" align="center" width="400">
        <tr>
            <td width="150">
                <input type="checkbox" name="choosedImage">
                <c:out value="${image.type}"/>
            </td>
            <td width="100"><c:out value="${image.size}"/></td>
            <td width="150"><c:out value="${image.addingdate}"/></td>
        </tr>
    </table>
</c:forEach>
<hr/>
<form method="post">
    <table border="1">
        <tr>
            <td width="100">Type</td>
            <td>
                <select name="type" style="width: 180px">
                    <option value="vector">Vector image</option>
                    <option value="bitmap">Bitmap image</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="100">Size</td>
            <td><input type="number" name="size"></td>
        </tr>
    </table>
</form>
<table width="300" align="left">
    <tr>
        <td>
            <input type="submit" value="Add image" name="Ok">
        </td>
        <td align="right">
            <button>Create Movie</button>
        </td>
    </tr>
</table>
</body>
</html>
