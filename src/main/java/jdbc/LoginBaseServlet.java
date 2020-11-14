package jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides base functionality to all servlets in this example.
 * Example of Prof. Engle
 * @see LoginServer
 */
@SuppressWarnings("serial")
public class LoginBaseServlet extends HttpServlet {

	protected static Logger log = LogManager.getLogger();
	protected static final LoginDatabaseHandler dbhandler = LoginDatabaseHandler.getInstance();

	protected void prepareResponse(String title, HttpServletResponse response) {
		try {
			PrintWriter writer = response.getWriter();

			writer.printf("<!DOCTYPE html>%n%n");
			writer.printf("<html lang=\"en\">%n%n");
			writer.printf("<head>%n");
			writer.printf("\t<title>%s</title>%n", title);
			writer.printf("\t<meta charset=\"utf-8\">%n");
			writer.printf("</head>%n%n");
			writer.printf("<body>%n%n");
		}
		catch (IOException ex) {
			log.warn("Unable to prepare HTTP response.");
			return;
		}
	}

	protected void finishResponse(HttpServletResponse response) {
		try {
			PrintWriter writer = response.getWriter();

			writer.printf("%n");
			writer.printf("<p style=\"font-size: 10pt; font-style: italic;\">");
			writer.printf("Last updated at %s.", getDate());
			writer.printf("</p>%n%n");

			writer.printf("</body>%n");
			writer.printf("</html>%n");

			writer.flush();

			response.setStatus(HttpServletResponse.SC_OK);
			response.flushBuffer();
		}
		catch (IOException ex) {
			log.warn("Unable to finish HTTP response.");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
	}

	protected String getDate() {
		String format = "hh:mm a 'on' EEE, MMM dd, yyyy";
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(Calendar.getInstance().getTime());
	}

	protected Map<String, String> getCookieMap(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				map.put(cookie.getName(), cookie.getValue());
			}
		}

		return map;
	}

	protected void clearCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		if(cookies == null) {
			return;
		}

		for(Cookie cookie : cookies) {
			cookie.setValue("");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}

	protected void clearCookie(String cookieName, HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	protected void debugCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if(cookies == null) {
			log.info("Saved Cookies: []");
		}
		else {
			String[] names = new String[cookies.length];

			for(int i = 0; i < names.length; i++) {
				names[i] = String.format("(%s, %s, %d)",
						cookies[i].getName(),
						cookies[i].getValue(),
						cookies[i].getMaxAge());
			}

			log.info("Saved Cookies: " + Arrays.toString(names));
		}
	}

	protected String getStatusMessage(String errorName) {
		Status status = null;

		try {
			status = Status.valueOf(errorName);
		}
		catch (Exception ex) {
			log.debug(errorName, ex);
			status = Status.ERROR;
		}

		return status.toString();
	}

	protected String getStatusMessage(int code) {
		Status status = null;

		try {
			status = Status.values()[code];
		}
		catch (Exception ex) {
			log.debug(ex.getMessage(), ex);
			status = Status.ERROR;
		}

		return status.toString();
	}

	protected String getUsername(HttpServletRequest request) {
		Map<String, String> cookies = getCookieMap(request);

		String login = cookies.get("login");
		String user  = cookies.get("name");

		if ((login != null) && login.equals("true") && (user != null)) {
			// this is not safe!
			return user;
		}

		return null;
	}
}