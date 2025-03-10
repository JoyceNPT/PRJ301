<%@page import="model.Users"%>
<%@page import="dao.UsersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

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
                    <a class="text-dark text-decoration-none" href="#">Login</a>
                </div>
            </nav>

            <!-- Form đăng nhập -->
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 50vh;">
                <div class="w-50">
                    <h1 class="text-center mb-4">Login</h1>
                    <form method="POST" action="Login">
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" name="username" id="u_id" required placeholder="Enter username">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" name="password" id="u_pwd" required placeholder="Enter your password">
                        </div>
                        <div class="text-left">
                            <button type="submit" id="submit" class="btn btn-primary"><i class="bi bi-person-circle"></i> Login</button>
                        </div>
                    </form>
                </div>
            </div>

            <%
                String err = (String) request.getAttribute("err");
                if (err != null) {
                    out.println(err);
                }
            %>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</body>
</html>
