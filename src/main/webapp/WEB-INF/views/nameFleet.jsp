<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<head>
    <title>Fleet</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Fleet Form</h1>
<p><a href="/">Back to index</a></p>
<%--@elvariable id="fleet" type="java"--%>
<h2>Input new fleet name</h2>
<form:form method="post" modelAttribute="fleet">
    <form:input path="name" />
    <input type="submit" value="Save">
</form:form>
</body>
