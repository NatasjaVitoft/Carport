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

        // gets parameter from user input

        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));

        int shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedlength"));

        //int price = (int) session.getAttribute("price");

        //sets the attribute from session

        session.setAttribute("width", width);
        session.setAttribute("length", length);

        session.setAttribute("shedwidth", shedWidth);
        session.setAttribute("shedlength", shedLength);

        ArrayList<BillOfMaterialLine> materials1 = new ArrayList<>();
        ArrayList<BillOfMaterialLine> materials2 = new ArrayList<>();

        try {
            materials1 = CalculatorList.calculateCarport(connectionPool, 0, width, length, shedLength, shedWidth);
        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            materials2 = CalculatorList.calculateCarport2(connectionPool, 0, width, length, shedWidth, shedLength);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        int price = 0;

        for (BillOfMaterialLine b : materials1) {
            price += b.getPrice();
        }

        for (BillOfMaterialLine b : materials2) {
            price += b.getPrice();
        }

        session.setAttribute("totalprice", price);

        //forward to svgpage.jsp
        request.getRequestDispatcher("SVGPage.jsp").forward(request, response);
    }
}







