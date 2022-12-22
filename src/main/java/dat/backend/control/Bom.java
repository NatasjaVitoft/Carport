package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Bom", value = "/Bom")
public class Bom extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int hiddenID = Integer.parseInt(request.getParameter("hiddenid"));
        session.setAttribute("hiddenID", hiddenID);
        request.getRequestDispatcher("Stykliste.jsp").forward(request, response);
        response.sendRedirect("Stykliste.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int ID = (int) session.getAttribute("hiddenID");

        BillOfMaterialLineFacade.readBOM(request, connectionPool, ID);
        BomVariantFacade.readBOM(request, connectionPool, ID);

        request.getRequestDispatcher("Stykliste.jsp").forward(request, response);
        response.sendRedirect("Stykliste.jsp");
    }
}
