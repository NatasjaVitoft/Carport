package dat.backend.control;

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

@WebServlet(name = "SVGTop", value = "/svgtop")
public class SVGTop extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.getSession();

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        int width = (int) session.getAttribute("width");
        int height = (int) session.getAttribute("length");
        int shedWidth = (int) session.getAttribute("shedwidth");
        int shedLength = (int) session.getAttribute("shedlength");




        SVGDrawing carport = HelpFunction.createNewSVG(0, 0, height, width, "0 0 855 690");
        carport = HelpFunction.addBeams(carport, height, width);


        request.setAttribute("svg", carport.toString());


        //forward to
        request.getRequestDispatcher("SVGDrawingTop.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
