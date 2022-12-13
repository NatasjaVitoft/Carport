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

    static BillOfMaterialLine createBOML(int material_id, String name, String unit, int length, int price, String description, int carport_id, int quantity, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        BillOfMaterialLine billOfMaterialLine;
        String sql = "insert into billofmaterialline (material_id, name, unit, length, price, description, carport_id, quantity ) values (?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, material_id);
                ps.setString(2, name);
                ps.setString(3, unit);
                ps.setInt(4, length);
                ps.setInt(5, price);
                ps.setString(6, description);
                ps.setInt(7, carport_id);
                ps.setInt(8, quantity);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    billOfMaterialLine = new BillOfMaterialLine(material_id, name, unit, length, price, description, carport_id, quantity);
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
