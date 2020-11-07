package cookiesAndSessions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
		
		PrintWriter out = response.getWriter();
		out.println("<html><title>DateServlet</title><body>");

		out.println("<p> " + "Today is " + getDate() +  "</p><br>");
		out.println("</body></html>");	
	}

	public static String getDate() {
		String format = "hh:mm a 'on' EEEE, MMMM dd yyyy";
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
	
}