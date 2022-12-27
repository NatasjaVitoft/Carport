package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.services.HelpFunction;
import dat.backend.model.services.SVGDrawing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "SVGAfterPurchase", value = "/svgafterpurchase")
public class SVGAfterPurchase extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.getSession();
        Order currentOrder = null;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        int ID = (int) session.getAttribute("ID");

        try {
            currentOrder = OrderFacade.getOrderByID(ID, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        int length = currentOrder.getLength();
        int width = currentOrder.getWidth();
        int shedwidth = currentOrder.getShedwidth();
        int shedlength = currentOrder.getShedlength();

        SVGDrawing carport = HelpFunction.createNewSVG(0, 0, 80, 60, "0 -30 1500 1500");
        SVGDrawing carport2 = HelpFunction.createNewSVG(0, 0, 100, 100, "0 -30 1500 1500");

        HelpFunction.addShed(carport, length, width, shedwidth, shedlength);
        HelpFunction.addRafter(carport, carport2, length, width);
        HelpFunction.addStrap1(carport, carport2, length, width);
        HelpFunction.addStrap2(carport, carport2, length, width);
        HelpFunction.addPostToShed(carport, carport2, length, width, shedwidth, shedlength);
        HelpFunction.addDashedLines(carport, length, width, shedwidth, shedlength);
        HelpFunction.addPost(carport, carport2, length, width);


        request.setAttribute("svg", carport.toString());
        request.getRequestDispatcher("SVGDrawingTop.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int ID = Integer.parseInt(request.getParameter("ID"));
        session.setAttribute("ID", ID);
        request.getRequestDispatcher("SVGDrawingTop.jsp").forward(request, response);
        response.sendRedirect("SVGDrawingTop.jsp");
    }
}
