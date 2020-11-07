package cookiesAndSessions;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Demonstrates how to use servlet contexts to configure which servlets handle
 * which requests.
 * Modified from the example of Prof. Engle.
 */
public class ContextServer {

    /** The hard-coded port to run this server. */
    public static final int PORT = 8080;

    /**
     * Sets up a Jetty server with two different servlet context handlers.
     *
     * @param args unused
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Server server = new Server(PORT);

        // Context 1
        ServletContextHandler context1 = new ServletContextHandler();
        context1.setContextPath("/health");

        context1.addServlet(BMIServlet.class, "/bmi");
        context1.addServlet(ExerciseServlet.class, "/");

        // Context 2
        ServletContextHandler context2 = new ServletContextHandler();
        context2.setContextPath("/date");
        context2.addServlet(DateServlet.class, "/");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { context1, context2 });

        server.setHandler(handlers);
        server.start();
        server.join();

        // http://localhost:8080/health/
        // http://localhost:8080/health/bmi
        // http://localhost:8080/health/nowhere
        // http://localhost:8080/health/exercise

        // http://localhost:8080/date
        // http://localhost:8080/date/nowhere
    }
}