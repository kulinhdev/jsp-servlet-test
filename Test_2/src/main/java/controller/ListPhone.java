package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMobileDAO;
import dao.ImplMobileDAO;
import utils.Mobile;

/**
 * Servlet implementation class ListPhone
 */
@WebServlet("/mobile")
public class ListPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPhone() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String s_name = request.getParameter("s_name");

		String order_by = request.getParameter("order_by");

		String getAllSql = "SELECT * FROM Mobile";

		if (s_name != null || order_by != null) {
			getAllSql = "SELECT * FROM Mobile WHERE name LIKE '%" + s_name + "%' ORDER BY id " + order_by;
		}

		IMobileDAO mobileDAO = new ImplMobileDAO();
		List<Mobile> listPhone = mobileDAO.selectAll(getAllSql);

		request.setAttribute("listPhone", listPhone);

		request.setAttribute("s_name", s_name);
		request.setAttribute("order_by", order_by);

		request.getRequestDispatcher("views/list-phone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
