package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;
import dat.backend.model.services.CalculatorList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AddOrder", value = "/addorder")
public class AddOrder extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Order order = null;
        HttpSession session = request.getSession();
        request.getSession();

        // Gets width and length attribute & username and user attribute from the sessionscope

        int width = (int) session.getAttribute("width");
        int length = (int) session.getAttribute("length");

        int shedWidth = (int) session.getAttribute("shedwidth");
        int shedLength = (int) session.getAttribute("shedlength");

        String username = (String) session.getAttribute("username");
        User user = (User) session.getAttribute("user");

        // if user is not null create order (user is logged in)

        if (username != null) {
            try {
                order = OrderFacade.createOrder(username, 1000, user.getEmail(), "Fladt tag", length, width, shedWidth, shedLength, connectionPool);
                request.setAttribute("order", order);
                session.setAttribute("orderID", order.getOrder_id());
            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            // Initializing Arraylist allMaterial and allMaterial2

            ArrayList<BillOfMaterialLine> allMaterial = new ArrayList<>();
            ArrayList<BillOfMaterialLine> allMaterial2 = new ArrayList<>();

            // Adding the calculated items list to allMaterial list and getting each element of the list by a foreach loop.
            // Creating BOM line in the database by calling createBOML

            try {
                allMaterial = CalculatorList.calculateCarport(connectionPool, order.getOrder_id(), width, length, shedWidth, shedLength);

            } catch (DatabaseException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (BillOfMaterialLine a : allMaterial) {
                System.out.println(a);

                try {
                    BillOfMaterialLineFacade.createBOML(a.getItem_id(), a.getName(), a.getUnit(), a.getLength(), a.getPrice(), a.getDescription(), a.getQuantity(), a.getOrders_id(), connectionPool);
                } catch (DatabaseException e) {
                    e.printStackTrace();
                }
            }

            try {
                allMaterial2 = CalculatorList.calculateCarport2(connectionPool, order.getOrder_id(), width, length, shedWidth, shedLength);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            // Adding the calculated items list to allMaterial2 list and getting each element of the list by a foreach loop.
            // Creating BOMVariant line in the database by calling createBOMLVariant

            for (BillOfMaterialLine b : allMaterial2) {
                try {
                    BomVariantFacade.createBOMLVariant(b.getName(), b.getUnit(), b.getPrice(), b.getDescription(), b.getQuantity(), b.getOrders_id(), b.getItemVariant_id(), connectionPool);
                } catch (DatabaseException e) {
                    e.printStackTrace();
                }
            }

            request.getRequestDispatcher("minSide.jsp").forward(request, response);
            response.sendRedirect("minSide.jsp");

        } else {
            request.setAttribute("loginError", "Du skal være logget ind for at oprette en ordre");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        OrderFacade.readOrder(request, connectionPool, username);
        request.getRequestDispatcher("minSide.jsp").forward(request, response);
        response.sendRedirect("minSide.jsp");
    }
}
