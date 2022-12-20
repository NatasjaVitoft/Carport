package dat.backend.model.persistence;


import dat.backend.model.entities.ItemVariant;
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

    public static Order createOrder(String username, int price, String email, String carport, int length, int width, ConnectionPool connectionPool) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        Order order;
        String sql = "insert into orders (price , username, email, carport, length, width ) values (?,?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, price);
                ps.setString(2, username);
                ps.setString(3, email);
                ps.setString(4, carport);
                ps.setInt(5, length);
                ps.setInt(6, width);

                int rowsAffected = ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int auto_id = rs.getInt(1);
                if (rowsAffected == 1) {
                    order = new Order(username, price, email, carport, length, width);
                    order.setOrder_id(auto_id);
                }

                else {
                    throw new DatabaseException("Could not insert order into database");
                }
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }
        return order;

    }

    public static void readOrder(HttpServletRequest request, ConnectionPool connectionPool, String usernameInput) {

        List<Order> orderList = new ArrayList<>();
        HttpSession session = request.getSession();

        String sql = "select * from orders WHERE username = ? ";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, usernameInput);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int order_id = resultSet.getInt("orders_id");
                String username = resultSet.getString("username");
                Timestamp date = resultSet.getTimestamp("date");
                int price = resultSet.getInt("price");
                String email = resultSet.getString("email");
                String carport = resultSet.getString("carport");
                int length = resultSet.getInt("length");
                int width = resultSet.getInt("width");


                Order order = new Order(date, username, order_id, price, email, carport, length, width);
                orderList.add(order);
            }
            session.setAttribute("orderlist", orderList);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static Order getOrdersIDByUsername(int username, ConnectionPool connectionPool) throws DatabaseException {

        Order orders = null;

        String sql = "SELECT * FROM order WHERE username = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, username);

                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {

                    int order_id = resultSet.getInt("orders_id");

                    orders = new Order(order_id);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong");
        }
        return orders;
    }
}
