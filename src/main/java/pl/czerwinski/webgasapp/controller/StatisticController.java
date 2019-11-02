package pl.czerwinski.webgasapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.czerwinski.webgasapp.model.User;
import pl.czerwinski.webgasapp.service.UserService;


@WebServlet("/stat")
public class StatisticController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saveStatisticInRequest(request);
		request.getRequestDispatcher("WEB-INF/statistic.jsp").forward(request, response);
	}

	private void saveStatisticInRequest(HttpServletRequest request) {
		UserService userService = new UserService();
		String username = request.getUserPrincipal().getName();
		userService.saveStatisticByUsername(username);
		User statisticByUsername = userService.getUserByUsername(username);
		request.setAttribute("statistic", statisticByUsername);
	}

}
