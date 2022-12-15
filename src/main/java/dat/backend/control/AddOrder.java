package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BillOfMaterialLineFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.UserFacade;
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
import java.util.List;

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

        int width = (int) session.getAttribute("width");
        int length = (int) session.getAttribute("length");

        String username = (String) session.getAttribute("username");
        User user = (User) session.getAttribute("user");

        try {
            if(user!=null) {
                order = OrderFacade.createOrder(username, 1000, user.getEmail(), "Fladt tag", length, width, connectionPool);
                request.setAttribute("order", order);
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        ArrayList <BillOfMaterialLine> allMaterial = new ArrayList<>();

        try {
            allMaterial = (ArrayList<BillOfMaterialLine>) CalculatorList.calculateCarport(connectionPool, order.getOrder_id(), width, length);

        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (BillOfMaterialLine a : allMaterial) {
            System.out.println(a);

            try {
                BillOfMaterialLineFacade.createBOML(a.getItem_id(), a.getName(), a.getUnit(), a.getLength(), a.getPrice(), a.getDescription(), a.getCarport_id(), a.getQuantity(), a.getOrders_id(), connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
