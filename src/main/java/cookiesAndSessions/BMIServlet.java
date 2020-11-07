package cookiesAndSessions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class BMIServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
		out.println("<html><title>BMIServlet</title><body>");

		try {
			double height = Double.parseDouble(request.getParameter("height")); // inches
			double weight = Double.parseDouble(request.getParameter("weight")); // in pounds

			double bmi = 703.0 * weight / (height * height);
			getServletContext().setAttribute("weight", weight);
			out.println("<p> BMI is: " + bmi + "</p><br>");
		}
		catch (Exception e) {
			System.out.println("Could not parse the file.");
		}
		out.println("</body></html>");	
	}
	

	
}