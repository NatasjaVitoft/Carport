package dat.backend.model.persistence;

import dat.backend.model.entities.Item;
import dat.backend.model.entities.ItemVariant;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemVariantMapper {

    public static ArrayList<ItemVariant> ItemVariantList(ConnectionPool connectionPool) throws DatabaseException {

        ArrayList<ItemVariant> itemVariantList = new ArrayList<>();

        String sql = "SELECT * FROM beslag_skruer";

        try (
                Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("idBeslag_skruer");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    String unit = rs.getString("unit");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");

                    ItemVariant itemVariant = new ItemVariant(id, name, description, price, unit, quantity);
                    itemVariantList.add(itemVariant);

                }if (itemVariantList.size()==0)
                {
                    throw new DatabaseException("Something went wrong listing itemVariant");
                }

            }
        } catch (
                SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Error with itemVariant. Something went wrong with the database");
        }
        return itemVariantList;
    }
}
