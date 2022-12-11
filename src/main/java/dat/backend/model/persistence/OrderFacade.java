package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;

public class OrderFacade {

    public static Order createOrder(String username, int price, String email, String carport, ConnectionPool connectionPool) throws DatabaseException {

        return OrderMapper.createOrder(username, price, email, carport, connectionPool);

    }

    public static void readOrder(HttpServletRequest request, ConnectionPool connectionPool){

        OrderMapper.readOrder(request, connectionPool);

    }
}
