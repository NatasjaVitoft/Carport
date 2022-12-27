package dat.backend.model.persistence;

import dat.backend.model.entities.Item;
import dat.backend.model.entities.ItemVariant;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVariantMapper {

    public static ItemVariant getItemVariantByID(int ID, ConnectionPool connectionPool) throws DatabaseException {

        ItemVariant itemVariants = null;

        String sql = "SELECT * FROM itemvariant WHERE itemvariant_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, ID);

                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {

                    int variantID = resultSet.getInt("itemvariant_id");
                    String description = resultSet.getString("description");
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    int price = resultSet.getInt("price");

                    itemVariants = new ItemVariant(variantID, name, description, price, unit);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong");
        }
        return itemVariants;
    }
}
