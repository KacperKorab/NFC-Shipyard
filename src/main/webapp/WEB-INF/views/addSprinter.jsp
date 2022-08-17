<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Ship</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p><a href="/">Back to index</a></p>
<h1>Ship Form</h1>
<%--@elvariable id="ship" type="java"--%>
<h2>Input new ship name</h2>
<form:form method="post" modelAttribute="ship">
    <form:input type="text" path="name" />
    <table>
        <c:forEach items="${ship.sockets}" var="socket">
            <tr>
<%--                <td><c:out value="${socket.socketName}" /></td>--%>
                <td>
                    <jsp:useBean id="allComponents" scope="request" type="java.util.List"/>
                    <c:out value="${socket.socketName} ${allComponents[1].componentName}"/>
<%--                    <form:select path="ship.sockets">--%>
<%--                        <form:options items="${allComponents}" />--%>
<%--                    </form:select>--%>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Save">
</form:form>
<p>Fleet name: ${fleet.name}</p>
<table>
    <c:forEach items="${fleet.ships}" var="ship">
        <tr>
            <td><c:out value="${ship}" /></td>
        </tr>
    </c:forEach>
</table>
</body>