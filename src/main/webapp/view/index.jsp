<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Image Gallery</title>
</head>
<body>
<h1 align="center">Welcome to Image Gallery!!!</h1>
<div align="center">
    <c:forEach var="image" items="${requestScope.images}">
        <input type="checkbox" id="0">
        <u><c:out value="${image.type}"/>:</u>
        <b> Size - </b><label for="0"><c:out value="${image.size} kB"/></label>
        <b>Date of add - </b><label for="0"><c:out value="${image.addingdate}"/></label></p>
    </c:forEach>
</div>
<hr/>


<%--<form method="get" action="<c:url value='/create'/>">--%>
    <%--<input type="number" hidden name="id" value="${user.id}"/>--%>
    <%--<input type="submit" value="Редактированть"/>--%>
<%--</form>--%>

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
