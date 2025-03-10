/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Category;
import model.Product;
import model.Users;

/**
 *
 * @author ngoth
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/Product"})
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDAO pdao = new ProductDAO();
        CategoryDAO cdao = new CategoryDAO();

        Users acc = (Users) session.getAttribute("login");
        if (acc == null) {
            response.sendRedirect("Login");
            return;
        }

        String action = (String) request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        if (action.equalsIgnoreCase("list")) {
            List<Product> list = pdao.getAll();

            request.setAttribute("list", list);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("create")) {
            List<Category> list = cdao.getAll();

            request.setAttribute("list", list);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("update")) {
            String idRaw = request.getParameter("id");
            int id = 0;

            try {
                id = Integer.parseInt(idRaw);
                Product pro = pdao.getById(id);

                request.setAttribute("data", pro);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
                System.out.println(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("delete")) {
            String idRaw = request.getParameter("id");
            int id = 0;

            try {
                id = Integer.parseInt(idRaw);
                Product pro = pdao.getById(id);

                request.setAttribute("deleteData", pro);
                request.getRequestDispatcher("delete.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (String) request.getParameter("action");
        ProductDAO pdao = new ProductDAO();

        if (action.equalsIgnoreCase("create")) {
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String name = request.getParameter("name");
                String priceRaw = request.getParameter("price");
                String quantityRaw = request.getParameter("quantity");
                String descript = request.getParameter("description");
                String catRaw = request.getParameter("cat");

                long price = Long.parseLong(priceRaw);
                int quantity = Integer.parseInt(quantityRaw);
                int cat = Integer.parseInt(catRaw);

                int result = pdao.create(name, price, quantity, descript, cat);

                if (result > 0) {
                    response.sendRedirect("Product");
                } else {
                    request.setAttribute("err", "<p>Create failed</p>");
                    request.getRequestDispatcher("create.jsp").forward(request, response);
                }
            }
        } else if (action.equalsIgnoreCase("update")) {
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String idRaw = request.getParameter("id");
                String name = request.getParameter("name");
                String priceRaw = request.getParameter("price");
                String quantityRaw = request.getParameter("quantity");
                String descript = request.getParameter("description");
                String catRaw = request.getParameter("cat");

                try {
                    int id = Integer.parseInt(idRaw);
                    long price = Long.parseLong(priceRaw);
                    int quantity = Integer.parseInt(quantityRaw);
                    int cat = Integer.parseInt(catRaw);

                    int result = pdao.update(id, name, price, quantity, descript, cat);

                    if (result > 0) {
                        response.sendRedirect("Product");
                    } else {
                        request.setAttribute("err", "<p>Update failed</p>");
                        request.getRequestDispatcher("update.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    PrintWriter out = response.getWriter();
                    out.print(e.getMessage());
                    System.out.println(e.getMessage());
                }
            }
        } else if (action.equalsIgnoreCase("delete")) {
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String idRaw = request.getParameter("id");

                try {
                    int id = Integer.parseInt(idRaw);

                    int result = pdao.delete(id);
                    if (result > 0) {
                        response.sendRedirect("Product");
                    } else {
                        request.setAttribute("err", "<p>Delete failed</p>");
                        request.getRequestDispatcher("delete.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    PrintWriter out = response.getWriter();
                    out.print(e.getMessage());
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
