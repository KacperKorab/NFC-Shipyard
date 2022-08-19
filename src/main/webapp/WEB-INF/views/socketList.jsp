<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p><a href="/">Back to index</a></p>
<p><a href="/shipList">Ship list</a></p>
<h1>Nebulous: Fleet Command Shipyard</h1>
<p>Fleet name: ${fleet.name}</p>
<%--@elvariable id="shipChoice" type="java"--%>
<%--<form:form method="post" modelAttribute="shipChoice">--%>
<%--    <form:input type="number" path="shipChoice"/>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form:form>--%>
<table>
    <c:forEach items="${ship.sockets}" var="socket" varStatus="status">
        <tr>
            <td><c:out value="${status.count} :"/></td>
            <td><a href="/shipList/socketList/socket?shipId=${shipId}&socketId=${status.count}">Modify</a></td>
            <td><c:out value="${socket.socketName} - ${socket.componentName}" /></td>
        </tr>
    </c:forEach>
</table>