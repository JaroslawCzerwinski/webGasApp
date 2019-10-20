package pl.czerwinski.webgasapp.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.czerwinski.webgasapp.model.Refuel;
import pl.czerwinski.webgasapp.service.RefuelService;

@WebServlet("")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		saveRefuelingsInRequest(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void saveRefuelingsInRequest(HttpServletRequest request) {
		RefuelService refuelingService = new RefuelService();
		String username = request.getUserPrincipal().getName();
		List<Refuel> refuelingsByUsername = refuelingService.getRefuelsByUsername(new Comparator<Refuel>() {
			// more distance = higher
			@Override
			public int compare(Refuel r1, Refuel r2) {
				int r1Distance = r1.getDistance();
				int r2Distance = r2.getDistance();
				if (r1Distance < r2Distance) {
					return 1;
				} else if (r1Distance > r2Distance) {
					return -1;
				}
				return 0;
			}
		}, username);
		{

			request.setAttribute("refuelings", refuelingsByUsername);
		}
	}
}