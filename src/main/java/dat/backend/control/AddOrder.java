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
import java.awt.*;
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

        // gets width and length attribute from the session

        int width = (int) session.getAttribute("width");
        int length = (int) session.getAttribute("length");

        int shedWidth = (int) session.getAttribute("shedwidth");
        int shedLength = (int) session.getAttribute("shedlength");

        // gets the user and username attribute from the session

        String username = (String) session.getAttribute("username");
        User user = (User) session.getAttribute("user");




        // if user is ! null set order

        if (username!=null){
            try {
                order = OrderFacade.createOrder(username, 1000, user.getEmail(), "Fladt tag", length, width, connectionPool);
                request.setAttribute("order", order);
                session.setAttribute("orderID", order.getOrder_id());

                // instance of Arraylist allMaterial

                ArrayList <BillOfMaterialLine> allMaterial = new ArrayList<>();
                ArrayList <BillOfMaterialLine> allMaterial2 = new ArrayList<>();




                try {
                    allMaterial = (ArrayList<BillOfMaterialLine>) CalculatorList.calculateCarport(connectionPool, order.getOrder_id(), width, length, shedWidth, shedLength);

                } catch (DatabaseException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // adding the calculated items to allMaterial list and calls the method createBomL
                int price = 0;

                for (BillOfMaterialLine a : allMaterial) {
                    System.out.println(a);
                    price += a.getPrice();


                    try {
                        BillOfMaterialLineFacade.createBOML(a.getItem_id(), a.getName(), a.getUnit(), a.getLength(), a.getPrice(), a.getDescription(), a.getQuantity(), a.getOrders_id(), connectionPool);
                    } catch (DatabaseException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    allMaterial2 = (ArrayList<BillOfMaterialLine>) CalculatorList.calculateCarport2(connectionPool, order.getOrder_id(), width, length, shedWidth, shedLength);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (DatabaseException e) {
                    e.printStackTrace();
                }

                for(BillOfMaterialLine b : allMaterial2) {
                    try {
                        BomVariantFacade.createBOMLVariant(b.getName(), b.getUnit(), b.getPrice(), b.getDescription(), b.getQuantity(), b.getOrders_id(), b.getItemVariant_id(), connectionPool);
                    } catch (DatabaseException e) {
                        e.printStackTrace();
                    }
                }


                // if succed go to minSide.jsp
                request.getRequestDispatcher("minSide.jsp").forward(request, response);

            } catch (DatabaseException e) {

            }
        }else{
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
