<%-- 
    Document   : edit-movie
    Created on : Feb 24, 2025, 11:36:45 AM
    Author     : ngoth
--%>

<%@page import="dao.moviesDAO"%>
<%@page import="model.users"%>
<%@page import="model.movies"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    users acc = (users) session.getAttribute("login");
    if (acc == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    movies mov = null;
    moviesDAO dao = new moviesDAO();
    String account = acc.getUsername();
    String idRaw = request.getParameter("id");
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
        <title>Edit movie</title>
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
            <h1 style="font-weight: 400;" value='Edit movie'>Edit movie</h1>

            <form method="POST">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Title</label>
                    <input id="title" type="text" class="form-control" name="title" required>
                </div>

                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Director</label>
                    <input id="director" type="text" class="form-control" name="director" required>
                </div>

                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Release Year</label>
                    <input id="release_year" type="number" min="1900" max="2024" class="form-control" name="release_year" required>
                </div>

                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Rating</label>
                    <input id="rating" type="number" min="0.0" max="10.0" step="0.1" class="form-control" name="rating" required>
                </div>

                <div class="mb-3 form-check d-flex align-items-center gap-2" style="padding-left: 0;">
                    <label class="form-check-label" for="is_rented">Is Rented?</label>
                    <input id="is_rented" type="checkbox" class="form-check-input" id="exampleCheck1" name="Is_rented" value="true" style="margin: 0%">
                </div>

                <a id="back" class="btn btn-secondary" href="movies.jsp" class="btn btn-primary">Back</a>
                <button id="submit" type="submit" class="btn btn-primary">Edit</button>
            </form>

            <%
                if (request.getMethod().equalsIgnoreCase("POST")) {
                    String title = request.getParameter("title");
                    String director = request.getParameter("director");
                    String release_yearRaw = request.getParameter("release_year");
                    String ratingRaw = request.getParameter("rating");
                    String Is_rentedRaw = request.getParameter("Is_rented");

                    int release_year = Integer.parseInt(release_yearRaw);
                    double rating = Double.parseDouble(ratingRaw);
                    boolean Is_rented = false;
                    if (Is_rentedRaw != null) {
                        Is_rented = true;
                    }

                    int update = dao.update(id, title, director, release_year, rating, Is_rented);

                    if (update > 0) {
                        response.sendRedirect("movies.jsp");
                    } else {
                        out.println("<h1 style='color: red; text-align: center;'>Update Data Failed</h1>");
                    }
                }
            %>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
