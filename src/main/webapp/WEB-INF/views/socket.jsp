<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>socket</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p><a href="/">Back to index2</a></p>
<p><a href="/shipList">Back to shipList</a></p>
<%--@elvariable id="hullSocket" type="java"--%>
<h2>Choose component:</h2>
<c:out value="${hullSocket.socketName} - ${hullSocket.component.componentName}"/>
<%--@elvariable id="component" type="java"--%>
<form:form method="post" modelAttribute="component">
    <form:input type="text" path="componentName"/>
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