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

<div align="center">
    <h3>Your movie consist from :</h3><br/>
</div>
<%--<b><%= request.getParameterValues("choosedImage") %></b>--%>
<form action="/" method="get">
    <c:forEach var="image" items="${requestScope.selectedImages}">
        <table border="1px" align="center" width="450">
            <tr>
                <td width="150">
                    <c:out value="${image.type}"/>
                </td>
                <td width="150"><c:out value="${image.size}"/></td>
                <td width="150"><c:out value="${image.addingDate}"/></td>
            </tr>
        </table>
    </c:forEach>
    <div align="center" style="margin: 20px">
        <input type="submit" value="Ok" name="Ok">
    </div>
</form>
</body>
</html>
