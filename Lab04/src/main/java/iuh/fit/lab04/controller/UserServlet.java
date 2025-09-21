package iuh.fit.lab04.controller;

import iuh.fit.lab04.daos.Impl.UserDaoImpl;
import iuh.fit.lab04.models.User;
import iuh.fit.lab04.daos.UserDao;
import iuh.fit.lab04.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            UserDao userDAO = new UserDaoImpl(em);
            List<User> users = userDAO.findAll();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/listUser.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        User user = new User(name, email, country);

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            req.setAttribute("errors", violations);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
                UserDao userDAO = new UserDaoImpl(em);
                userDAO.save(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("message", "Register successful!");
            doGet(req, resp);
        }
    }
}