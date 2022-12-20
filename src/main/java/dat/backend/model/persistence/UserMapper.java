package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper
{
    static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    String email = rs.getString("email");
                    String address = rs.getString("adress");
                    String city = rs.getString("city");
                    int postcode = rs.getInt("postcode");
                    String name = rs.getString("name");
                    int phoneNumber = rs.getInt("phonenumber");

                    user = new User(username, password, role, email, address, city, postcode, name, phoneNumber);

                } else
                {
                    throw new DatabaseException("Forkert brugernavn eller kodeord.");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "noget gik galt i forbindelsen til databasen");
        }
        return user;
    }

    static User createUser(String username, String password, String role, String email, String address, String city, int postcode, String name, int phoneNumber, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (username, password, role, email, adress, city, postcode, name, phonenumber) values (?,?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                ps.setString(4, email);
                ps.setString(5, address);
                ps.setString(6, city);
                ps.setInt(7, postcode);
                ps.setString(8, name);
                ps.setInt(9, phoneNumber);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(username, password, role, email, address, city, postcode, name, phoneNumber);
                } else
                {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }

    static User getUserByUsername(String username, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "SELECT * FROM user WHERE username = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, username);

                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {

                    String username2 = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String city = resultSet.getString("city");
                    int postcode = resultSet.getInt("postcode");
                    String name = resultSet.getString("name");
                    int phoneNumber = resultSet.getInt("phonenumber");

                    User user = new User(username2, password, role, email, address, city, postcode, name, phoneNumber);
                    return user;
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong");
        }
        return null;
    }

    public static void readUser(HttpServletRequest request, ConnectionPool connectionPool, String username) {

        List<User> userList = new ArrayList<>();
        HttpSession session = request.getSession();

        String sql = "select * from bomvariant WHERE orders_id = ? ";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, username);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                String username2 = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                int postcode = resultSet.getInt("postcode");
                String name = resultSet.getString("name");
                int phoneNumber = resultSet.getInt("phonenumber");


                User users = new User(username2, password, role, email, address, city, postcode, name, phoneNumber);
                userList.add(users);
            }
            session.setAttribute("userliste", userList);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
