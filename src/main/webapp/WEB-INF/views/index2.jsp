<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p><a href="/">Back to index2</a></p>
<h1>Nebulous: Fleet Command Shipyard</h1>
<p>Fleet name: ${fleet.name}</p>
<%--<c:forEach items="${fleet.ships}" var="ship">--%>
<%--    ${ship}<br>--%>
<%--</c:forEach>--%>
<p><a href="/resetFleet">Reset fleet</a></p>
<p><a href="/nameFleet">Rename fleet</a></p>
<p><a href="/addSprinter2">Create new Sprinter</a></p>
<p><a href="/shipList">Ship list</a></p>
<p><a href="/download/${fleet.name}.fleet">Save fleet</a></p>

<table>
    <p>Ships:</p>
    <c:forEach items="${fleet.ships}" var="ship">
        <tr>
            <td><c:out value="${ship}" /></td>
        </tr>
    </c:forEach>
</table>