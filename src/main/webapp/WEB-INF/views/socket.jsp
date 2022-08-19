<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>socket</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p><a href="/">Back to index</a></p>
<p><a href="/shipList">Back to shipList</a></p>
<%--@elvariable id="hullSocket" type="java"--%>
<h3>Example components:</h3>
<table>
    <tr>
        <th>Component type</th>
        <th>Component names</th>
    </tr>
    <tr>
        <td>Mounting</td>
        <td>
            <ul>
                <li>RF101 &#39;Bullseye&#39; Radar</li>
                <li>Mk90 &#39;Aurora&#39; PDT</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td>Compartment</td>
        <td>
            <ul>
                <li>Basic CIC</li>
                <li>Berthing</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td>Module</td>
        <td>
            <ul>
                <li>FR3300 Micro Reactor</li>
                <li>FM200 Drive</li>
            </ul>
        </td>
    </tr>
</table>
<%--<c:out value="${hullSocket.socketName} - ${hullSocket.component.componentName}"/>--%>
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