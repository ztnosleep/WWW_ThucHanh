package iuh.fit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "tryDoGetDoPost", value = "/login",
        initParams = {
                @WebInitParam(name = "username", value = "user01"),
                @WebInitParam(name = "email", value = "user01@gmai.com")
        }
)
public class Servlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        writer.println("Login Data");
        writer.println("Username: " + req.getParameter("username"));
        writer.println("Password: " + req.getParameter("pwd"));

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        writer.println("Login Data");
        writer.println("Username: " + req.getParameter("username"));
        writer.println("Password: " + req.getParameter("pwd"));

        writer.close();
    }
}