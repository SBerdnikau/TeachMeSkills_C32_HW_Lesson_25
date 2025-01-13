<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
<header>
    <h1>You are logged in as,<span id="role"> ${sessionScope["role"] != null ? sessionScope["role"] : "" }</span></h1>
</header>
<main class="content">
    <h2 class="main-header">Welcome to our portal!</h2>
</main>
<footer>
    <p>&copy; 2025 Copyright</p>
    <p class="author">Developer by berdnikausiarhei@gmail.by</p>
</footer>
</body>
</html>
