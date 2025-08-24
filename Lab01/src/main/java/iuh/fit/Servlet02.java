package iuh.fit;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "infoServletJson", value = "/info-json",
        initParams = {
                @WebInitParam(name = "username", value = "user01"),
                @WebInitParam(name = "email", value = "user01@gmai.com")
        }
)
public class Servlet02 extends HttpServlet {
    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+ "Bài 2"+"</h1>");
        out.println("Param: " + this.getServletConfig().getInitParameter("username") + "\n");
        out.println("Param: " + this.getServletConfig().getInitParameter("email"));
        out.println("</body></html>");
    }
    public void destroy() {
    }
}