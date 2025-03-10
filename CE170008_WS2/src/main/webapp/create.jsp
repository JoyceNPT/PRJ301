<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users acc = (Users) session.getAttribute("login");
    if (acc == null) {
        response.sendRedirect("Login");
        return;
    }

    List<Category> list = (List<Category>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new product</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    </head>
    <body>
        <div class="container">

            <nav class="navbar navbar-light bg-light px-4">
                <a class="navbar-brand fw-light">Products</a>
                <div>
                    <a class="text-secondary text-decoration-none me-3">Products</a>
                    <span style="color: #757576;">Hi, <%= acc.getUser()%>, </span>
                    <a href="Logout" class="text-secondary text-decoration-none">logout</a>
                </div>
            </nav>


            <div class="container" style="margin-top: 3%;">
                <h1 style="font-weight: 400;">Create new product</h1>

                <form method="POST" action="Product?action=create">
                    <div class="mb-3">
                        <label class="form-label">Product Name</label>
                        <input id="pName" type="text" class="form-control" name="name" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Product Price</label>
                        <input id="pPrice" type="number" min="1" class="form-control" name="price" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Product Quantity</label>
                        <input id="pQuantity" type="number" min="0" class="form-control" name="quantity" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Product Description</label>
                        <input id="pDescription" type="text" class="form-control" name="description" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Category Name</label>
                        <select class="form-select" name="cat" id="cId" aria-label="Default select example">
                            <%
                                for (Category cat : list) {
                            %>
                            <option value="<%= cat.getId()%>"> <%= cat.getName()%> </option>
                            <%
                                }
                            %>
                        </select>
                    </div>

                    <a href="Product" class="btn btn-secondary" id="back"><i class="bi bi-arrow-return-left"></i> Back</a>
                    <button type="submit" class="btn btn-primary" id="submit"><i class="bi bi-file-earmark-plus"></i> Create</button>
                </form>

                <%
                    String err = (String) request.getAttribute("err");
                    if (err != null) {
                        out.println(err);
                    }
                %>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
