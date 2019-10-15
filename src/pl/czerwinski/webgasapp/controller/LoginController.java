package pl.czerwinski.webgasapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CZy u¿ytkownik jest zalogowany ? ");
		if(request.getUserPrincipal() != null) {
			
			System.out.println("User jest zalogowany nastêpuje przekierowanie");
			response.sendRedirect(request.getContextPath() + "/newRefuel.jsp");
			
		} else {
			response.sendError(403);
		}
	}

}
