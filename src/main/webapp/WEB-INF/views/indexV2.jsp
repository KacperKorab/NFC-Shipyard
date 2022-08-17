<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p><a href="/shipyardV2/">Back to index</a></p>
<h1>Nebulous: Fleet Command Shipyard</h1>

<h2>Add ship:</h2>
<p><a href="/sprinter">Sprinter</a></p>

<p>Fleet name: ${fleet.name}</p>
<table>
    <c:forEach items="${fleet.ships}" var="ship">
        <tr>
            <td><c:out value="${ship}" /></td>
        </tr>
    </c:forEach>
</table>