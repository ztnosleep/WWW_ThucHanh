package iuh.fit.lab04.controller;

import iuh.fit.lab04.daos.Impl.ProductDaoImpl;
import iuh.fit.lab04.daos.ProductDao;
import iuh.fit.lab04.models.CartItem;
import iuh.fit.lab04.models.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    @Resource(name = "jdbc/shopping")
    private DataSource dataSource;

    private ProductDao productDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productDao = new ProductDaoImpl(this.dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        if (action != null) {
            switch (action) {
                case "add":
                    int id = Integer.parseInt(req.getParameter("id"));
                    Product product = productDao.findAll().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                    if (product != null) {
                        CartItem existing = cart.stream().filter(item -> item.getProduct().getId() == id).findFirst().orElse(null);
                        if (existing != null) {
                            existing.setQuantity(existing.getQuantity() + 1);
                        } else {
                            cart.add(new CartItem(product, 1));
                        }
                    }
                    break;
                case "update":
                    int updateId = Integer.parseInt(req.getParameter("id"));
                    int quantity = Integer.parseInt(req.getParameter("quantity"));
                    CartItem updateItem = cart.stream().filter(item -> item.getProduct().getId() == updateId).findFirst().orElse(null);
                    if (updateItem != null) {
                        updateItem.setQuantity(quantity);
                    }
                    break;
                case "delete":
                    int deleteId = Integer.parseInt(req.getParameter("id"));
                    cart.removeIf(item -> item.getProduct().getId() == deleteId);
                    break;
            }
        }

        req.setAttribute("products", productDao.findAll());
        req.setAttribute("cart", cart);
        double total = cart.stream().mapToDouble(CartItem::getTotal).sum();
        req.setAttribute("total", total);

        req.getRequestDispatcher("/indexProduct.jsp").forward(req, resp);
    }
}