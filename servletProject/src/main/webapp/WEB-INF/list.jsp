<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>ListPage</h1>

    <url>
        <c:forEach var="dto" items="${list}">
            <li>${dto}</li>
        </c:forEach>

    </url>
</body>
</html>
