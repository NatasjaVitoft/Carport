package dat.backend.model.persistence;

import dat.backend.control.Item;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemMapper {

    public static ArrayList<Item> getItemList(ConnectionPool connectionPool) throws DatabaseException {

        ArrayList<Item> itemList = new ArrayList<>();

        String sql = "SELECT * FROM materialer";

        try (
                Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int item_id = rs.getInt("item_id");
                    String item_name = rs.getString("item_name");
                    String item_description = rs.getString("item_description");
                    int price = rs.getInt("price");

                    Item item = new Item(item_id, item_name, item_description, price);
                    itemList.add(item);

                }
                {
                    throw new DatabaseException("Something went wrong listing items");
                }
            }
        } catch (
                SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Error with items. Something went wrong with the database");
        }

        //return itemList;

    }

}
