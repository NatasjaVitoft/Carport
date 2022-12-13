package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillOfMaterialLineMapper {

    static BillOfMaterialLine createBOML(int item_id, String name, String unit, int length, int price, String description, int carport_id, int quantity, int orders_id, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        BillOfMaterialLine billOfMaterialLine;
        String sql = "insert into bom (item_id, name, unit, length, price, description, carport_id, quantity, orders_id ) values (?,?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, item_id);
                ps.setString(2, name);
                ps.setString(3, unit);
                ps.setInt(4, length);
                ps.setInt(5, price);
                ps.setString(6, description);
                ps.setInt(7, carport_id);
                ps.setInt(8, quantity);
                ps.setInt(9, orders_id);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    billOfMaterialLine = new BillOfMaterialLine(item_id, name, unit, length, price, description, carport_id, quantity, orders_id);
                } else
                {
                    throw new DatabaseException("Could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return billOfMaterialLine;
    }
}
