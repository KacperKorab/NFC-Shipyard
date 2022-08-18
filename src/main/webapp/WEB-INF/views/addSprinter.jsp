<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Ship</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p><a href="/">Back to index</a></p>
<h1>New Sprinter class hull</h1>
<%--@elvariable id="ship" type="java"--%>
<h2>Input new ship name</h2>
<form:form method="post" modelAttribute="ship">
    <form:input type="text" path="name"/>
    <h2>Select component to modify</h2>
<%--    <form:select path="sockets[${status.count}].component">&ndash;%&gt;--%>
<%--        <form:options items="${ship.sockets}" itemLabel="socketName"/>--%>
<%--    </form:select>--%>
        <table>
            <c:forEach items="${ship.sockets}" var="socket" varStatus="status">
                <tr>
                    <td>
                        <c:out value="${socket.socketName}" />
                    </td>
                    <td>
                        <c:out value="${socket.hullSocketType}" />
                    </td>
                    <td>
                        <c:out value="${socket.component.componentName}" />
                    </td>
                    <td>
                        <jsp:useBean id="allComponents" scope="request" type="java.util.List"/>
                        <form:select  path="sockets[${status.count}].component">
                            <form:options items="${allComponents}" itemLabel="componentName"/>
                        </form:select>
                    </td>
                </tr>
            </c:forEach>
        </table>
    <c:out value="after table end"/>
    <input type="submit" value="Save">
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