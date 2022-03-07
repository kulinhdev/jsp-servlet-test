package controller;

import java.io.IOException;
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
 * Servlet implementation class UpdateMobilePost
 */
@WebServlet("/update")
public class UpdateMobilePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMobilePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("p_id"));
		String name = request.getParameter("p_name");
		Float price = Float.parseFloat(request.getParameter("p_price"));
		Boolean status = Boolean.parseBoolean(request.getParameter("p_status"));
		String warranty = request.getParameter("p_warranty");
		String accessory = request.getParameter("p_accessory");
		String image = request.getParameter("p_image");

		Mobile mobile = new Mobile(id, name, price, status, warranty, accessory, image);

		IMobileDAO idao = new ImplMobileDAO();

		boolean result = idao.update(mobile);

		if (result)
			request.setAttribute("info", "Update record success!");
		else
			request.setAttribute("info", "Update record failed!");

		response.sendRedirect(request.getContextPath() + "/edit?id=" + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
