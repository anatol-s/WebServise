package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MyResponse;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        MyResponse myResponse = new MyResponse();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(myResponse), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();

        Logger.getLogger(Main.class.getName()).info("Server started");

        server.join();
    }
}
