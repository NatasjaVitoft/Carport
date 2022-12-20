package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.*;
<<<<<<< HEAD
=======
import dat.backend.model.services.HelpFunction;
>>>>>>> a97e80cb65621c742ae067020d28f8b3487e8159

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

        int shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedlength"));

        //int price = (int) session.getAttribute("price");


        //drawing

        String generateSvgTop = "";

        generateSvgTop = HelpFunction.drawCarportFladtSideView(length);


        request.setAttribute("generateSvgTop", generateSvgTop);


        //sets the attribute from session

        session.setAttribute("width", width);
        session.setAttribute("length", length);
<<<<<<< HEAD
        session.setAttribute("shedwidth", shedWidth);
        session.setAttribute("shedlength", shedLength);
        session.setAttribute("SVGTop", SVGTop);
=======
        //session.setAttribute("price", price);
        session.setAttribute("generateSvgTop", generateSvgTop);
>>>>>>> a97e80cb65621c742ae067020d28f8b3487e8159
        

        //forward to svgpage.jsp
        request.getRequestDispatcher("SVGPage.jsp").forward(request, response);
    }
}







