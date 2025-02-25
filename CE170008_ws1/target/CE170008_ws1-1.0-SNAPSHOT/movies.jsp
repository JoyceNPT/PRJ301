<%-- 
    Document   : movies
    Created on : Feb 23, 2025, 7:54:09 PM
    Author     : ngoth
--%>

<%@page import="model.movies"%>
<%@page import="dao.moviesDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.usersDAO"%>
<%@page import="model.users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    users acc = (users) session.getAttribute("login");
    if (acc == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String account = acc.getUsername();
    moviesDAO dao = new moviesDAO();
    List<movies> list = dao.getAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies list</title>
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
            <h1 style="font-weight: 400;" value='Movies list'>Movies list</h1>
            <div class="text-end mb-2">
                <a class="btn btn-success" href="create-movie.jsp">Create</a>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Director</th>
                        <th>Release Year</th>
                        <th>Rating</th>
                        <th>Rent?</th>
                        <th>Actions</th>
                    </tr>
                </thead>

                <%
                    if (list != null) {
                        for (movies movi : list) {
                %>

                <tr>
                    <td><%= movi.getId()%></td>
                    <td><%= movi.getTitle()%></td>
                    <td><%= movi.getDirector()%></td>
                    <td><%= movi.getRelease_year()%></td>
                    <td><%= movi.getRating()%></td>
                    <td>
                        <%
                            if (movi.getIs_rented()) {
                        %>    
                        <input class="form-check-input" type="checkbox" name="" value="" checked disabled/>
                        <%
                        } else {
                        %>
                        <input type="checkbox" name="" value="" disabled/>
                        <%
                            }
                        %>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="edit-movie.jsp?id=<%= movi.getId()%>">Edit</a>
                        <a class="btn btn-danger" href="delete-movie.jsp?id=<%= movi.getId()%>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%  } else {
                    out.println("<h1 style='color: red; text-align: center;'>No Data!</h1>");
                }
            %>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
