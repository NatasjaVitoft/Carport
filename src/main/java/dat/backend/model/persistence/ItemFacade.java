package dat.backend.model.persistence;

import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;

public class ItemFacade {

    public static Item getItemByID(int ID, ConnectionPool connectionPool) throws DatabaseException {
        return ItemMapper.getItemByID(ID, connectionPool);
    }
}
