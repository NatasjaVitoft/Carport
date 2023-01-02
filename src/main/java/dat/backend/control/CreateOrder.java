package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import dat.backend.model.services.CalculatorList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;


@WebServlet(name = "CreateOrder", value = "/createorder")
public class CreateOrder extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.getSession();

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        // Gets parameters from user input
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedlength"));

        // Sets session attributes to be what we get from user input
        session.setAttribute("width", width);
        session.setAttribute("length", length);
        session.setAttribute("shedwidth", shedWidth);
        session.setAttribute("shedlength", shedLength);


        // Initialize variable and surround method call with a try catch statement.
        // Method that calculates total price for each carport. Order ID is always 0 because it shouldn't create an order yet.
        int price = 0;

        try {
            price = CalculatorList.calculateTotalPrice(connectionPool, 0, length, width, shedLength, shedWidth);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        // Set totalprice attribute
        session.setAttribute("totalprice", price);

        // Forward to svgpage.jsp
        request.getRequestDispatcher("SVGPage.jsp").forward(request, response);
    }
}







