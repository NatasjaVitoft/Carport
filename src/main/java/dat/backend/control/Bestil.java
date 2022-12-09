package dat.backend.control;

import dat.backend.model.entities.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "bestil", value = "/bestil")
public class Bestil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //sender tilbage til index.
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<Item> itemSession;
        itemSession = (ArrayList<Item>) session.getAttribute("items");
        if (itemSession == null){
            itemSession = new ArrayList<>();
        }

        response.sendRedirect("bestil.jsp");

    }


}
