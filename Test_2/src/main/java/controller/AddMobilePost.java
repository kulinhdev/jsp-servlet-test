package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMobileDAO;
import dao.ImplMobileDAO;
import utils.Mobile;

/**
 * Servlet implementation class AddMobilePost
 */
@WebServlet("/create")
public class AddMobilePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMobilePost() {
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

		Random rand = new Random();

		int id = rand.nextInt(1000);

		String name = request.getParameter("p_name");
		Float price = Float.parseFloat(request.getParameter("p_price"));
		Boolean status = Boolean.parseBoolean(request.getParameter("p_status"));
		String warranty = request.getParameter("p_warranty");
		String accessory = request.getParameter("p_accessory");
		String image = request.getParameter("p_image");

		Mobile mobile = new Mobile(id, name, price, status, warranty, accessory, image);

		IMobileDAO idao = new ImplMobileDAO();

		boolean result = idao.insert(mobile);

		if (result)
			request.setAttribute("info", "Add new record success!");
		else
			request.setAttribute("info", "Add new record failed!");

		request.getRequestDispatcher("views/add-phone.jsp").forward(request, response);
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
