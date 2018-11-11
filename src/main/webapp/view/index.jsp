<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Image Gallery</title>
</head>
<body>
<h1 align="center">Welcome to Image Gallery!!!</h1>
<form method="get">
    <table border="1px" align="center" width="450">
        <tr>
            <th width="150">
                <input type="radio" name="sort" value="sortByType">
                <a href="/" title="Press to sort" onclick="">Type of image</a></th>
            <th width="150">
                <input type="radio" name="sort" value="sortBySize">
                <a href="/" title="Press to sort">Size in px</a></th>
            <th width="150">
                <input type="radio" name="sort" value="sortByDate">
                <a href="/" title="Press to sort">Date added</a></th>
        </tr>
    </table>
</form>
<c:forEach var="image" items="${requestScope.images}">
    <table border="1px" align="center" width="450">
        <tr>
            <td width="150">
                <input type="checkbox" name="choosedImage">
                <c:out value="${image.type}"/>
            </td>
            <td width="150"><c:out value="${image.size}"/></td>
            <td width="150"><c:out value="${image.addingDate}"/></td>
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
    <table width="300" align="left">
        <tr>
            <td>
                <input type="submit" value="Add image">
            </td>
            <td align="right">
                <button>Create Movie</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
