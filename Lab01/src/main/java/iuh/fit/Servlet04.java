package iuh.fit;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/form-register",
        initParams = {
                @WebInitParam(name = "username", value = "user01"),
                @WebInitParam(name = "email", value = "user01@gmai.com")
        }
)
public class Servlet04 extends HttpServlet {

}