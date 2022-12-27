package dat.backend.model.persistence;

import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemMapper {

    public static Item getItemByID(int ID, ConnectionPool connectionPool) throws DatabaseException {

        Item items = null;

        String sql = "SELECT * FROM item WHERE item_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, ID);

                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {

                    int itemID = resultSet.getInt("item_id");
                    String description = resultSet.getString("description");
                    int length = resultSet.getInt("length");
                    ;
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    int price = resultSet.getInt("price");

                    items = new Item(itemID, name, description, price, unit, length);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong");
        }
        return items;
    }
}
