package pl.czerwinski.webgasapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/add")
public class DataInputFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;

		if (httpReq.getMethod().equals("GET")) {
			chain.doFilter(request, response);
		} else {
			boolean dataCorect = dataIsValidate(httpReq);
			if (dataCorect) {
				chain.doFilter(request, response);
			} else {
				request.getRequestDispatcher("WEB-INF/newRefuel.jsp").forward(request, response);
			}
		}
	}

	private boolean dataIsValidate(HttpServletRequest httpReq) {
		int distance = Integer.parseInt(httpReq.getParameter("distance"));
		Double lpgAmount = Double.parseDouble(httpReq.getParameter("lpgAmount"));
		Double lpgPrice = Double.parseDouble(httpReq.getParameter("lpgPrice"));
		Double petrolAmount = Double.parseDouble(httpReq.getParameter("petrolAmount"));
		Double petrolPrice = Double.parseDouble(httpReq.getParameter("petrolPrice"));

		boolean distanceOK = checkDistance(distance);
		boolean lpgAmountOK = checkLpgAmount(lpgAmount);
		boolean lpgPriceOK = checkLpgPrice(lpgPrice);
		boolean petrolAmountOK = checkPetrolAmount(petrolAmount);
		boolean petrolPriceOK = checkPetrolPrcie(petrolPrice);

		if (distanceOK && lpgAmountOK && lpgPriceOK && petrolAmountOK && petrolPriceOK) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkDistance(int distance) {
		if (String.valueOf(distance).matches("[^-0]\\d{0,5}")) {
			return true;
		}
		return false;

	}

	private boolean checkLpgAmount(Double lpgAmount) {
		if (String.valueOf(lpgAmount).matches("[^-]\\d{0,5}([\\.,]\\d{0,2})?")) {
			return true;
		}
		return false;

	}

	private boolean checkLpgPrice(Double lpgPrice) {
		if (String.valueOf(lpgPrice).matches("[^-0]\\d{0,5}([\\.,]\\d{0,2})?")) {
			return true;
		}
		return false;

	}

	private boolean checkPetrolAmount(Double petrolAmount) {
		if (String.valueOf(petrolAmount).matches("[^-]\\d{0,5}([\\.,]\\d{0,2})?")) {
			return true;
		}
		return false;

	}

	private boolean checkPetrolPrcie(Double petrolPrice) {
		if (String.valueOf(petrolPrice).matches("[^-0]\\d{0,5}([\\.,]\\d{0,2})?")) {
			return true;
		}
		return false;

	}
}
