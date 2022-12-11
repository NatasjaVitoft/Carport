package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Bestil", value = "/bestil")
public class Bestil extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<Item> itemSession;
        //ArrayList<Carport> inventorySession;
        //Carport carport = (Carport) session.getAttribute("carport");


        itemSession = (ArrayList<Item>) session.getAttribute("items");
        if (itemSession == null){
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
            itemSession.add(new Item(0,itemName,"beskrivelse",0));
            session.setAttribute("item", itemSession);

        }

        response.sendRedirect("index.jsp");

    }


}
