package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Item;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;
import dat.backend.model.services.CalculatorList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "bestil", value = "/bestil")
public class Bestil extends HttpServlet {

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

        Order order;
        HttpSession session = request.getSession();
        request.getSession();

        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));

        String username = (String) session.getAttribute("username");
        User user = (User) session.getAttribute("user");

            try {
                order = OrderFacade.createOrder(username, 1000, user.getEmail(), "Fladt tag", length, width, connectionPool);
                CalculatorList.calculateCarport(order.getOrder_id(), width, length);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }


        /*

        ArrayList<Carport> inventorySession;

        ArrayList<Item> itemSession;

        itemSession = (ArrayList<Item>) session.getAttribute("items");
        if (itemSession == null) {
            itemSession = new ArrayList<>();
        }

        ArrayList<Item> items = null;

        try {
            items = ItemFacade.itemList(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <items.size();i++){

            System.out.println("kommer vi herind?: " + i);

            String itemName = items.get(i).getItem_name();
            int ID = items.get(i).getItem_id();
            String description = items.get(i).getItem_description();
            int price = items.get(i).getPrice();
            String unit = items.get(i).getUnit();
            int length1 = items.get(i).getLength();
            int quantity = 0;

            itemSession.add(new Item(ID, itemName,description, price, unit, quantity, length1));
            session.setAttribute("item", itemSession);
        }
        System.out.println(itemSession);


         */
    }

