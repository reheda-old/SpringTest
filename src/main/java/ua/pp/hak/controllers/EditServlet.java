package ua.pp.hak.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.pp.hak.models.DAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null && request.getParameter("txt") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String txt = request.getParameter("txt");
			request.setAttribute("postId", id);
			request.setAttribute("postTxt", txt);
			request.getRequestDispatcher("./posts").forward(request, response);
		} else {
			response.sendRedirect("./posts");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String txt = request.getParameter("txt");

		if (txt != null && txt.length() <= 255) {
			DAO.editPost(id, txt);
		} 

		response.sendRedirect("./posts");
	}

}
