package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillOfMaterialLineMapper {

    // Mapper

    public static BillOfMaterialLine createBOML(int item_id, String name, String unit, int length, int price, String description, int quantity, int orders_id, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        BillOfMaterialLine billOfMaterialLine;

        // Insert data into database bom
        String sql = "insert into bom (item_id, name, unit, length, price, description, quantity, orders_id ) values (?,?,?,?,?,?,?,?)";
        // get connection
        try (Connection connection = connectionPool.getConnection()) {
            // Make a prepared statement
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                // sets the new values into a new database object
                ps.setInt(1, item_id);
                ps.setString(2, name);
                ps.setString(3, unit);
                ps.setInt(4, length);
                ps.setInt(5, price);
                ps.setString(6, description);
                ps.setInt(7, quantity);
                ps.setInt(8, orders_id);

                // executing update
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    billOfMaterialLine = new BillOfMaterialLine(item_id, name, unit, length, price, description, quantity, orders_id);
                } else {
                    throw new DatabaseException("Could not be inserted into the database");
                }
            }
            // exception thrown if data couldnt insert into database
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert bom into database");
        }

        return billOfMaterialLine;
    }

    public static void readBOM(HttpServletRequest request, ConnectionPool connectionPool, int ordersID) {

        List<BillOfMaterialLine> billOfMaterialLineList = new ArrayList<>();
        HttpSession session = request.getSession();

        String sql = "select * from bom WHERE orders_id = ? ";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, ordersID);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                int length = resultSet.getInt("length");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");


                BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(name, unit, length, price, description, quantity);
                billOfMaterialLineList.add(billOfMaterialLine);
            }
            session.setAttribute("stykliste", billOfMaterialLineList);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
