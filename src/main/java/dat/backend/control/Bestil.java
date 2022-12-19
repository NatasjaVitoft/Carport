package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.*;
import dat.backend.model.services.HelpFunction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;


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

        HttpSession session = request.getSession();
        request.getSession();

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        // gets parameter from user input

        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        //int price = (int) session.getAttribute("price");


        //drawing

        String generateSvgTop = "";

        generateSvgTop = HelpFunction.drawCarportFladtSideView(length);


        request.setAttribute("generateSvgTop", generateSvgTop);






        //sets the attribute from session

        session.setAttribute("width", width);
        session.setAttribute("length", length);
        //session.setAttribute("price", price);
        session.setAttribute("generateSvgTop", generateSvgTop);
        

        //forward to svgpage.jsp
        request.getRequestDispatcher("SVGPage.jsp").forward(request, response);
    }
}







