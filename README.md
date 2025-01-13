

1. Implement the LoginServlet servlet, which will process HTTP requests for user login (username and password are passed as parameters in the path). If such a user is found in the system, save the role (for example, "USER" or "ADMIN") and the username in the session scope.
2. Implement the HomeServlet servlet, which will display a message about who is logged in and their role. If the user is not logged in, you need to inform them that access is denied (text or 401 status code).
3. Configure Listener to log in all users who are logged in.
