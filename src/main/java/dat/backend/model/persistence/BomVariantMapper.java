package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BomVariantMapper {

    public static BillOfMaterialLine createBOMLVariant(String name, String unit, int price, String description, int quantity, int orders_id, int itemvariant_id, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        BillOfMaterialLine billOfMaterialLine;
        String sql = "insert into bomvariant (name, unit, price, description, quantity, orders_id, itemvariant_id) values (?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, name);
                ps.setString(2, unit);
                ps.setInt(3, price);
                ps.setString(4, description);
                ps.setInt(5, quantity);
                ps.setInt(6, orders_id);
                ps.setInt(7, itemvariant_id);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    billOfMaterialLine = new BillOfMaterialLine(itemvariant_id, name, unit, price, description, quantity, orders_id);
                } else
                {
                    throw new DatabaseException("Could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {  System.out.println("KIG HER KIG HER" + ex);
            throw new DatabaseException(ex, "Could not insert bom into database");
        }


        return billOfMaterialLine;
    }
}
