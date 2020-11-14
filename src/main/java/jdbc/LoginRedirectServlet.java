package jdbc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Redirects to welcome page or login page depending on whether user
 * session is detected.
 * Example of Prof. Engle
 *
 * @see LoginServer
 */
@SuppressWarnings("serial")
public class LoginRedirectServlet extends LoginBaseServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (getUsername(request) != null) {
			response.sendRedirect("/welcome");
		}
		else {
			response.sendRedirect("/login");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doGet(request, response);
	}
}