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
    Choose type <label>
    <select name="type">
        <option value="vector">Vector image</option>
        <option value="bitmap">Bitmap image</option>
    </select>
</label>
    <br/>
    Image size<label><input type="number" name="size"></label><br/>
    <input type="submit" value="Add image" name="Ok">
</form>

<table align="center">
    <tr>
        <form method="get" action="<c:url value='/create'/> ">
            <td>
                <button>Add Image</button>
            </td>
        </form>
        <td>
            <button>Sort by size</button>
        </td>
        <%--<td><button>Find by type</button></td>--%>
        <td><select name="types">
            <option value="">Choose type filter</option>
            <option value="vector">Vector image</option>
            <option value="bitmap">Bitmap image</option>
        </select>
        </td>
    </tr>
    <tr>
        <td>
            <button>Create Movie</button>
        </td>
        <td>
            <button>Sort by date</button>
        </td>
        <td>
            <button>Find by created date</button>
        </td>
        <td><input type="date" name="id" value="${requestScope.image.id}"></td>

    </tr>
</table>
<form method="get" action="<c:url value="create.jsp"/> "></form>
</body>
</html>
