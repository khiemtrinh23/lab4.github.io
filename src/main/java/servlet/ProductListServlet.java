package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import connect.ConnectionUtils;
import utils.productUtils;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ProductListServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn=null;
		String errorString = null;
		List<Product> list = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
				try {
					list = productUtils.queryProduct(conn);
				} catch (SQLException e) {
					e.printStackTrace();
					errorString = e.getMessage();
				}
				// Store info in request attribute, before forward to views
				request.setAttribute("errorString", errorString);
				request.setAttribute("prodcutList", list);
				
				// Forward to /WEB-INF/views/productList.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/productList.jsp");
				dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			//TODO Auto-generared catch block
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // TODO Auto-generated method stub
		 doGet(request, response);
	 }
}
