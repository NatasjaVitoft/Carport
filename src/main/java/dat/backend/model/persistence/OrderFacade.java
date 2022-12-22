package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;

public class OrderFacade {

    public static Order createOrder(String username, int price, String email, String carport, int length, int width, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.createOrder(username, price, email, carport, length, width, connectionPool);
    }

    public static void readOrder(HttpServletRequest request, ConnectionPool connectionPool, String username){
        OrderMapper.readOrder(request, connectionPool, username);
    }

    public static Order getOrderByID(int ID, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getOrderByID(ID, connectionPool);
    }
}
