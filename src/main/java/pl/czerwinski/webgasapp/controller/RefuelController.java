package pl.czerwinski.webgasapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.czerwinski.webgasapp.model.User;
import pl.czerwinski.webgasapp.service.RefuelService;

@WebServlet("/add")
public class RefuelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getUserPrincipal() != null) {
			request.getRequestDispatcher("WEB-INF/newRefuel.jsp").forward(request, response);
		} else {
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int distance = Integer.parseInt(request.getParameter("distance")); 
		String date = request.getParameter("date");
		Double lpgAmount = Double.parseDouble(request.getParameter("lpgAmount"));
		Double lpgPrice = Double.parseDouble(request.getParameter("lpgPrice"));
		Double petrolAmount = Double.parseDouble(request.getParameter("petrolAmount"));
		Double petrolPrice = Double.parseDouble(request.getParameter("petrolPrice"));
		Double gasEfficiency = Double.parseDouble(request.getParameter("slider"));
		User authenticatedUser = (User) request.getSession().getAttribute("user");
		
		if(request.getUserPrincipal() != null) {
			RefuelService refuelService = new RefuelService();
			refuelService.addRefuel(distance, date, lpgAmount, lpgPrice, petrolAmount, petrolPrice, gasEfficiency, authenticatedUser);
			response.sendRedirect(request.getContextPath() + "/history");
		} else {
			response.sendError(403);
		}
	}

}
