package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BomVariantMapper {

    public static BillOfMaterialLine createBOMLVariant(String name, String unit, int price, String description, int quantity, int orders_id, int itemvariant_id, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        BillOfMaterialLine billOfMaterialLine;
        String sql = "insert into bomvariant (name, unit, price, description, quantity, orders_id, itemvariant_id) values (?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, unit);
                ps.setInt(3, price);
                ps.setString(4, description);
                ps.setInt(5, quantity);
                ps.setInt(6, orders_id);
                ps.setInt(7, itemvariant_id);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    billOfMaterialLine = new BillOfMaterialLine(itemvariant_id, name, unit, price, description, quantity, orders_id);
                } else {
                    throw new DatabaseException("Could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            System.out.println("KIG HER KIG HER" + ex);
            throw new DatabaseException(ex, "Could not insert bom into database");
        }


        return billOfMaterialLine;
    }

    public static void readBOMVariant(HttpServletRequest request, ConnectionPool connectionPool, int ordersID) {

        List<BillOfMaterialLine> billOfMaterialLineList = new ArrayList<>();
        HttpSession session = request.getSession();

        String sql = "select * from bomvariant WHERE orders_id = ? ";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, ordersID);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");


                BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(name, unit, price, description, quantity);
                billOfMaterialLineList.add(billOfMaterialLine);
            }
            session.setAttribute("styklistevariant", billOfMaterialLineList);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
