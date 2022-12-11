package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public static Order createOrder(String username, int price, String email, String carport, ConnectionPool connectionPool) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        Order order;
        String sql = "insert into orders (price , username, email, carport ) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, price);
                ps.setString(2, username);
                ps.setString(3, email);
                ps.setString(4, carport);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    order = new Order(username, price, email, carport);
                } else {
                    throw new DatabaseException("Could not insert order into database");
                }
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }
        return order;

    }

    public static void readOrder(HttpServletRequest request, ConnectionPool connectionPool) {

        List<Order> orderList = new ArrayList<>();
        HttpSession session = request.getSession();

        String sql = "select * from orders ";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int order_id = resultSet.getInt("idOrders");
                String username = resultSet.getString("username");
                Timestamp date = resultSet.getTimestamp("date");
                int price = resultSet.getInt("price");
                String email = resultSet.getString("email");
                String carport = resultSet.getString("carport");

                Order order = new Order(date,username, order_id, price, email, carport);
                orderList.add(order);
            }
            session.setAttribute("orderlist", orderList);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}