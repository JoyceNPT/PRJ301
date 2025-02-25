<%-- 
    Document   : login.jsp
    Created on : Feb 23, 2025, 1:55:56 PM
    Author     : ngoth
--%>

<%@page import="dao.usersDAO"%>
<%@page import="model.users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    users acc = new users();
    usersDAO dao = new usersDAO();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
            .h1-head {
                text-align: center;
                font-weight: 400;
            }

            .form-login {
                display: flex;
                justify-content: center;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light px-4">
            <a class="navbar-brand fw-light">MovieRental</a>
            <div>
                <a class="text-secondary text-decoration-none me-3">Movies</a>
                <a href="login.jsp" class="text-secondary text-decoration-none">Login</a>
            </div>
        </nav>

        <h1 class="h1-head" value='Login' style="margin-top: 3%;">Login</h1>

        <div class="row form-login">
            <form class="col-md-3" method="POST">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Username</label>
                    <input id="u_id" type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="Enter username" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input id="u_pwd" type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Enter your password" required>
                </div>
                <button id="submit" type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>

        <%      if (request.getMethod().equalsIgnoreCase("POST")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                acc = dao.verify(username, password);

                if (acc.getId() != -1) {
                    response.sendRedirect("movies.jsp");
                    session.setAttribute("login", acc);
                } else {
                    out.println("<p style='color: red; text-align: center;'>Username invalid, password invalid</p>");
                }
            }
        %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
