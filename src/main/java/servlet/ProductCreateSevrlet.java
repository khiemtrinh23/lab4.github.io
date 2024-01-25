package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productCreate")
public class ProductCreateSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ProductCreateSevrlet() {
		super();
	}
// Hiển thị trang thêm mới sản phẩm.
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
		dispatcher.forward(request, response);
	}
// Khi người dùng nhất nút ghi (submit).
// Phương thức doPost sẽ được gọi.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
}
