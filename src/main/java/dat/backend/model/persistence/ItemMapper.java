package dat.backend.model.persistence;
import com.mysql.cj.protocol.Resultset;
import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemMapper {

    public static ArrayList<Item> getItemList(ConnectionPool connectionPool) throws DatabaseException {

        ArrayList<Item> itemList = new ArrayList<>();

        String sql = "SELECT * FROM item";

        try (
                Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int item_id = rs.getInt("item_id");
                    String item_name = rs.getString("name");
                    String item_description = rs.getString("description");
                    int price = rs.getInt("price");
                    int length = rs.getInt("length");
                    int quantity = rs.getInt("quantity");
                    String unit = rs.getString("unit");

                    Item item = new Item(item_id, item_name, item_description, price, unit, quantity, length);
                    itemList.add(item);

                }if (itemList.size()==0)
                {
                    throw new DatabaseException("Something went wrong listing items");
                }
            }
        } catch (
                SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Error with items. Something went wrong with the database");
        }
        return itemList;
    }

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
                    int length = resultSet.getInt("length");;
                    String name = resultSet.getString("name");
                    int quantity = resultSet.getInt("quantity");
                    String unit = resultSet.getString("unit");
                    int price = resultSet.getInt("price");

                    items = new Item(itemID, name, description, price, quantity, unit);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong");
        }
        return items;
    }
}
