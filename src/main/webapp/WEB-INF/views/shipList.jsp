<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p><a href="/">Back to index</a></p>
<h1>Nebulous: Fleet Command Shipyard</h1>
<p>Fleet name: ${fleet.name}</p>
<table>
    <c:forEach items="${fleet.ships}" var="ship" varStatus="status">
        <tr>
            <td><c:out value="${status.count} : ${ship.name} - ${ship.hullType}" /></td>
        </tr>
    </c:forEach>
</table>