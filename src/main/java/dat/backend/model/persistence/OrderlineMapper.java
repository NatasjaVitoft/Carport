package dat.backend.model.persistence;

import dat.backend.model.entities.Orderline;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderlineMapper {


    //Skal testes om vi mangler orderid, da den har relation i tabellen.

    public static Orderline create(int item_id, int various_id, int shed_id, int price, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Orderline orderLine;
        String sql = "insert into orderline (idMaterialer, idbeslag og skruer, idSkur, price) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, item_id);
                ps.setInt(2, various_id);
                ps.setInt(3, shed_id);
                ps.setInt(4, price);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    orderLine = new Orderline(item_id, various_id, shed_id, price);
                } else {
                    throw new DatabaseException("Could not insert order into database");
                }
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }
        return orderLine;
    }

}
