package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMobileDAO;
import dao.ImplMobileDAO;
import utils.Mobile;

/**
 * Servlet implementation class UpdateMobile
 */
@WebServlet("/edit")
public class UpdateMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMobile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int findId = Integer.parseInt(request.getParameter("id"));

		IMobileDAO idao = new ImplMobileDAO();

		Mobile findMobile = idao.findById(findId);

		if (findMobile != null) {
			request.setAttribute("phone", findMobile);

			request.getRequestDispatcher("views/edit-phone.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/mobile");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
