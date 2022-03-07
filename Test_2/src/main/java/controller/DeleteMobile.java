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
 * Servlet implementation class DeleteMobile
 */
@WebServlet("/delete")
public class DeleteMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int removeId = Integer.parseInt(request.getParameter("id"));

		IMobileDAO idao = new ImplMobileDAO();

		boolean isOk = idao.delete(removeId);

		if (isOk)
			request.setAttribute("info", "Remove record success!");
		else
			request.setAttribute("info", "Remove record failed!");

		// Redirect to home page
		response.sendRedirect(request.getContextPath() + "/mobile");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
