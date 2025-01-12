<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hello, <%= session.getAttribute("role") != null ? session.getAttribute("role") : "" %></h1>
</body>
</html>
