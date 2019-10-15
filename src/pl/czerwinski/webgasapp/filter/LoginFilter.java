package pl.czerwinski.webgasapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import pl.czerwinski.webgasapp.model.User;
import pl.czerwinski.webgasapp.service.UserService;

@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter gasApp siê wykona³");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		if(httpReq.getUserPrincipal() != null && httpReq.getSession().getAttribute("user") == null) {
			saveUserInSession(httpReq);
		}
		chain.doFilter(request, response);
	}

	private void saveUserInSession(HttpServletRequest request) {
		UserService userService = new UserService();
		String username = request.getUserPrincipal().getName();
		User userByUsername = userService.getUserByUsername(username);
		System.out.println("zaraz sprawdze w BD");
		request.getSession(true).setAttribute("user", userByUsername);
		System.out.println("sprawdzenie usera po jego imieniu w BD sie wykonalo");
	
	
	}

}
