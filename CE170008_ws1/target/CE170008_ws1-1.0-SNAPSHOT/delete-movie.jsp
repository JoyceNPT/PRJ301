<%-- 
    Document   : delete-movie
    Created on : Feb 24, 2025, 12:08:28 PM
    Author     : ngoth
--%>

<%@page import="dao.moviesDAO"%>
<%@page import="model.movies"%>
<%@page import="model.users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    users acc = (users) session.getAttribute("login");
    if (acc == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String idRaw = request.getParameter("id");
    movies mov = null;
    moviesDAO dao = new moviesDAO();
    String account = acc.getUsername();

    int id = 0;
    try {
        if (idRaw != null && !idRaw.trim().isEmpty()) {
            id = Integer.parseInt(idRaw);
        }
    } catch (NumberFormatException e) {
        response.sendRedirect("movies.jsp");
        return;
    }

    mov = dao.getById(id);
    if (mov == null) {
        response.sendRedirect("movies.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete movie</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <nav class="navbar navbar-light bg-light px-4">
            <a class="navbar-brand fw-light">MovieRental</a>
            <div>
                <a class="text-secondary text-decoration-none me-3">Movies</a>
                <span style="color: #757576;">Hi, <%= account%>, </span>
                <a href="logout.jsp" class="text-secondary text-decoration-none">logout</a>
            </div>
        </nav>

        <div class="container" style="margin-top: 3%;">
            <h1 style="font-weight: 400;" value='Delete movie'>Delete movie</h1>
            <p>
                Are you sure delete movie <b class="m_title"><%= mov.getTitle()%></b> with id <b class="m_id"><%= mov.getId()%></b>?
            </p>

            <div class="d-flex gap-2">
                <a id="back" class="btn btn-secondary" href="movies.jsp">Back</a>
                <form method="POST">
                    <button id="submit" type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>

        </div>

        <%
            if (request.getMethod().equalsIgnoreCase("POST")) {
                boolean delete = dao.delete(id);
                
                if(delete) {
                    response.sendRedirect("movies.jsp");
                } else {
                    out.println("<h1 style='color: red; text-align: center;'>An error occurred while deleting.</h1>");
                }
            }
        %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    </body>
</html>
