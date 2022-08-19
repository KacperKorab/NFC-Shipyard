<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Ship</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p><a href="/">Back to index</a></p>
<p><a href="/shipList">Ship list</a></p>
<p><a href="http://localhost:8080/shipList/socketList/socket?shipId=1&socketId=1">Component</a></p>
<h1>New Sprinter class hull</h1>
<%--@elvariable id="ship" type="java"--%>
<h2>Input new ship name</h2>
<form:form method="post" modelAttribute="ship">
    <form:input type="text" path="name"/>
    <input type="submit" value="Submit">
</form:form>
<p>Fleet name: ${fleet.name}</p>
<table>
    <c:forEach items="${fleet.ships}" var="ship">
        <tr>
            <td><c:out value="${ship}"/></td>
        </tr>
    </c:forEach>
</table>
</body>