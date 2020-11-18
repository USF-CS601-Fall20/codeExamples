package javascript;
/** The example shows an example of a server that serves static pages that contain javascript.
 *  Modified from the example of Prof. Rollins
 * 
 */
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class JSServerSimple {

	public static void main(String[] args) {

		// Example from
		// http://www.eclipse.org/jetty/documentation/current/embedding-jetty.html

		Server server = new Server(8080);
		ResourceHandler resource_handler = new ResourceHandler();
		resource_handler.setDirectoriesListed(true);

		resource_handler.setResourceBase("static"); // will serve files from the
													// static directory

		server.setHandler(resource_handler);
		try {
			server.start();
			server.join();

		} catch (Exception e) {
			System.out.println("Exception occured while running the server: " + e);
		}

	}

}