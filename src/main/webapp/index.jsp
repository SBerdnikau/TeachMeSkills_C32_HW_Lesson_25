<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
<main class="content">

    <h2 class="main-header">Welcome to our portal!</h2>

    <section id="section-1">
        <div class="login-container">
            <h2>Login</h2>
            <p class="error">${requestScope["error"] != null ? requestScope["error"] : "" }</p>
            <form method="post" action="login" class="login-form">
                <input type="text" name="userName" placeholder="Username" >
                <input type="password" name="userPassword" placeholder="Password" >
                <button type="submit">Login</button>
            </form>
        </div>
    </section>

</main>
<footer>
    <p>&copy; 2025 Copyright</p>
    <p class="author">Developer by berdnikausiarhei@gmail.by</p>
</footer>
</body>
</html>