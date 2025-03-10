<%@page import="dao.CategoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@page import="model.Product"%>
<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users acc = (Users) session.getAttribute("login");
    if (acc == null) {
        response.sendRedirect("Login");
        return;
    }

    Product pro = (Product) request.getAttribute("data");

    CategoryDAO cdao = new CategoryDAO();
    List<Category> list = cdao.getAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update product</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    </head>
    <body>
        <div class="container">
            <!-- Thanh điều hướng -->
            <nav class="navbar navbar-light bg-light px-3">
                <a class="navbar-brand" href="#">Products</a>
                <div class="ms-auto">
                    <a class="text-dark me-3 text-decoration-none" href="#">Products</a>
                    <span class="text-dark">Hi, <%= acc.getUser()%>, <a class="text-dark text-decoration-none" href="Logout">logout</a></span>
                </div>
            </nav>

            <h1 style="margin-top: 45px;">Update product</h1>

            <%
                if (pro == null) {
                    response.sendRedirect("Product");
                } else {
            %>
            <form method="POST" action="Product?action=update">
                <div class="mb-3">
                    <label class="form-label">Product ID</label>
                    <input type="text" class="form-control" name="id" id="pId" required value="<%= pro.getId()%>" readonly/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Product Name</label>
                    <input type="text" class="form-control" name="name" id="pName" value="<%= pro.getName()%>" required/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Product Price</label>
                    <input type="number" min="1" class="form-control" name="price" id="pPrice" value="<%= pro.getPrice()%>" required/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Product Quantity</label>
                    <input type="number" min="0" class="form-control" name="quantity" id="pQuantity" value="<%= pro.getQuantity()%>" required/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Product Description</label>
                    <input type="text" class="form-control" name="description" id="pDescription" value="<%= pro.getDescript()%>" required/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Category Name</label>
                    <select class="form-select" name="cat" id="cId" aria-label="Default select example">
                        <%
                            for (Category cat : list) {
                        %>
                        <option value="<%= cat.getId()%>" <%= (cat.getId() == pro.getCat().getId()) ? "selected" : ""%> > <%= cat.getName()%> </option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <a href="Product" class="btn btn-secondary" id="back"><i class="bi bi-arrow-return-left"></i> Back</a>
                <button type="submit" class="btn btn-primary" id="submit"><i class="bi bi-file-earmark-plus"></i> Update</button>
            </form>
            <%
                }
            %>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
