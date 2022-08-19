<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Nebulous: Fleet Command Shipyard</h2>
<%--<c:forEach items="${fleet.ships}" var="ship">--%>
<%--    ${ship}<br>--%>
<%--</c:forEach>--%>
<p><a href="/resetFleet">Reset fleet</a></p>
<p><a href="/nameFleet">Rename fleet</a></p>
<p><a href="/addSprinter2">Create new Sprinter</a></p>
<p><a href="/shipList">Ship list</a></p>
<p><a href="/download/${fleet.name}.fleet">Download fleet</a></p>
<p><a href="/saveToDB">Save fleet to database</a></p>

<table>
    <p>Fleet name: ${fleet.name}</p>
    <p>Ships:</p>
    <c:forEach items="${fleet.ships}" var="ship">
        <tr><td><c:out value="${ship.name} - ${ship.hullType}"/></td></tr>
        <tr>
            <td>
                <ul>
                    <c:forEach items="${ship.sockets}" var="socket">
                        <tr>
                            <td><c:out value="${socket.socketName}"/></td>
                            <td><c:out value="${socket.componentName}"/></td>
                        </tr>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>