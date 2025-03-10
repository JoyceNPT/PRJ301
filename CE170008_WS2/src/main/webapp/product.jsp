<%@page import="model.Product"%>
<%@page import="model.Users"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users acc = (Users) session.getAttribute("login");
    if (acc == null) {
        response.sendRedirect("Login");
        return;
    }

    List<Product> list = (List<Product>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products list</title>

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


            <h1 style="margin-top: 45px;">Products list</h1>

            <!-- Nút tạo mới -->
            <div class="mb-2 text-end">
                <a class="btn btn-success" href="Product?action=create"><i class="bi bi-file-earmark-plus"></i> Create</a>
            </div>
            <%
                if (list != null) {
            %>
            <table class="table table-striped table-hover">
                <tr>
                    <td>ID</td>
                    <td>Product Name</td>
                    <td>Product Price</td>
                    <td>Product Quantity</td>
                    <td>Product Description</td>
                    <td>Category Name</td>
                    <td>Action</td>
                </tr>
                <%
                    for (Product pro : list) {
                %>
                <tr>
                    <td><%= pro.getId()%></td>
                    <td><%= pro.getName()%></td>
                    <td><%= pro.getPrice()%></td>
                    <td><%= pro.getQuantity()%></td>
                    <td><%= pro.getDescript()%></td>
                    <td><%= pro.getCat()%></td>
                    <td>
                        <a href="Product?action=update&id=<%= pro.getId()%>" class="btn btn-primary"><i class="bi bi-tools"></i> Edit</a>
                        <a href="Product?action=delete&id=<%= pro.getId()%>" class="btn btn-danger"><i class="bi bi-trash"></i> Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
                } else {
                    out.println("No Data!");
                }
            %>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</body>
</html>
