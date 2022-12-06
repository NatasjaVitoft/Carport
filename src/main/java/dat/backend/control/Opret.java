package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Opret", value = "/Opret")

public class Opret extends HttpServlet {

    ConnectionPool connectionPool;
    UserFacade userFacade;

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
        session.setAttribute("user", null);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String address = request.getParameter("adresse");
        String city = request.getParameter("by");
        int postcode = Integer.parseInt(request.getParameter("postnummer"));
        String name = request.getParameter("fuldenavn");
        int phoneNumber = Integer.parseInt(request.getParameter("telefon"));

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        user.setAddress(address);
        user.setCity(city);
        user.setPostcode(postcode);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);

        System.out.println(password);

        try {
            if(UserFacade.getUserByUsername(username, connectionPool)!=null) {
                System.out.println("Already taken");
            } else {
                userFacade.createUser(username, password, email, role, address, city, postcode, name, phoneNumber, connectionPool);
                session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }
}