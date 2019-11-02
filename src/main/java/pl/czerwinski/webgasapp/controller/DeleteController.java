package pl.czerwinski.webgasapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.czerwinski.webgasapp.service.RefuelService;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getUserPrincipal() != null) {
			request.getRequestDispatcher("/history").forward(request, response);
		} else {
			response.sendError(403);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getUserPrincipal() != null) {
			long refuelId = Long.parseLong(request.getParameter("refuel_id"));
			RefuelService refuelService = new RefuelService();
			refuelService.deleteRefuelById(refuelId);
			response.sendRedirect(request.getContextPath() + "/history");
		} else {
			response.sendError(403);
		}
	}
}
