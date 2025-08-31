package iuh.fit;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "infoServletJson", value = "/info-json",
        initParams = {
                @WebInitParam(name = "username", value = "user01"),
                @WebInitParam(name = "email", value = "user01@gmai.com")
        }
)
public class Servlet02 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(getServletConfig().getInitParameter("id"));
        String name = getServletConfig().getInitParameter("name");
        String email = getServletConfig().getInitParameter("email");

        User user = new User(id, name, email);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);

        response.setContentType("application/json;charset=UTF-8");

        response.getWriter().write(jsonString);
    }
}