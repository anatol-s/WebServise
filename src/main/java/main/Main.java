package main;

import chat.WebSocketChatServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MyResponse;
import servlets.SignInServlet;
import servlets.SignUpServlet;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        MyResponse myResponse = new MyResponse();

        SignUpServlet signUp = new SignUpServlet();
        SignInServlet signIn = new SignInServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(myResponse), "/mirror");
        context.addServlet(new ServletHolder(signUp), "/signup");
        context.addServlet(new ServletHolder(signIn), "/signin");
        context.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();

        Logger.getLogger(Main.class.getName()).info("Server started");

        server.join();
    }
}
