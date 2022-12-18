package dat.backend.control;

import dat.backend.model.services.Calculator;
import dat.backend.model.services.HelpFunction;
import dat.backend.model.services.SVGDrawing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "SVG", value = "/svg")
public class SVG extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        SVGDrawing carport = HelpFunction.createNewSVG(0, 0, 100, 60, "0 0 855 690");
        carport = HelpFunction.addBeams(carport);

        request.setAttribute("svg", carport.toString());
        request.getRequestDispatcher("WEB-INF/svgdrawing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
