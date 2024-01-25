package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.ConnectionUtils;
import utils.productUtils;

@WebServlet("/productDelete")
public class ProductDeleteServlet extends  HttpServlet {
        private static final long serialVersionUID = 1L;
    public ProductDeleteServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String errorString=null;
        String code = (String) request.getParameter("code");
        Connection conn=null;
        try {
            conn=ConnectionUtils.getMSSQLConnection();
            productUtils.deleteProduct(conn, code);
        } catch (Exception e) {
            e.printStackTrace();
            errorString=e.getMessage();
        }
        if (errorString !=null) {
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productDeleteError.jsp");
            dispatcher.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/producList");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
