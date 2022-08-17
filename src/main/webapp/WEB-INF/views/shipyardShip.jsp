<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<head>
    <title>Ship</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Ship Form</h1>
<%--@elvariable id="ship" type="java"--%>
<h2>Input new ship name</h2>
<form:form method="post"
           modelAttribute="ship">
    <form:input type="text" path="name" />
    <form:select path="hullType" items="${ship.availableHullTypes}" />
    <input type="submit" value="Save">
</form:form>
</body>