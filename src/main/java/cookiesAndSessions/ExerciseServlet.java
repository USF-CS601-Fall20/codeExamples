package cookiesAndSessions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ExerciseServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

			double weight = 0;
			Object obj = getServletContext().getAttribute("weight");
			if (obj != null)
				weight = (Double)obj;
        	response.setContentType("text/html");
        	response.setStatus(HttpServletResponse.SC_OK);
		
			PrintWriter out = response.getWriter();
			out.println("<html><title>ExerciseServlet</title><body>");

			out.println("<p> " + "Reminder: you need to exercise daily" +  "</p><br>");
			out.println("<p> " + "Current Weight = " + weight + "</p><br>");

			out.println("</body></html>");
	}
	

	
}