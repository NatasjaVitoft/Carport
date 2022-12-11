package dat.backend.control;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddOrder", value = "/addorder")
public class AddOrder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("order", null);

        String username = (String) session.getAttribute("username");
        int price = (int) session.getAttribute("price");

        Order order = new Order();

        order.setUsername(username);
        order.setPrice(price);

        session = request.getSession();
        session.setAttribute("order", order);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
