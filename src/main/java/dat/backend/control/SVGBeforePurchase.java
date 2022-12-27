package dat.backend.control;

import dat.backend.model.services.HelpFunction;
import dat.backend.model.services.SVGDrawing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SVGBeforePurchase", value = "/SVGBeforePurchase")
public class SVGBeforePurchase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.getSession();

        int length = (int) session.getAttribute("length");
        int width = (int) session.getAttribute("width");
        int shedlength = (int) session.getAttribute("shedlength");
        int shedwidth = (int) session.getAttribute("shedwidth");


        SVGDrawing carport = HelpFunction.createNewSVG(0, 0, 80, 60, "0 -30 1500 1500");
        SVGDrawing carport2 = HelpFunction.createNewSVG(0, 0, 100, 100, "0 -30 1500 1500");
        SVGDrawing carportText = HelpFunction.createNewSVG(0, 0, 100, 100, "0 -30 1500 1500");

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
}
