<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p><a href="/">Back to index</a></p>
<h1>Nebulous: Fleet Command Shipyard</h1>
<p>Fleet name: ${fleet.name}</p>
<%--<c:forEach items="${fleet.ships}" var="ship">--%>
<%--    ${ship}<br>--%>
<%--</c:forEach>--%>
<p><a href="/shipyardFleet">Rename fleet</a></p>
<p><a href="/addSprinter">Create new Sprinter</a></p>
<p><a href="/shipyardModShip">Modify ships</a></p>

<table>
    <c:forEach items="${fleet.ships}" var="ship">
        <tr>
            <td><c:out value="${ship}" /></td>
        </tr>
    </c:forEach>
</table>