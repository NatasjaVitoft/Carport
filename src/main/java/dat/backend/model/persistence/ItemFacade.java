package dat.backend.model.persistence;

import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class ItemFacade {


    public static ArrayList<Item> itemList(ConnectionPool connectionPool) throws DatabaseException {

        return ItemMapper.getItemList(connectionPool);

    }

    public static Item getItemByID(int ID, ConnectionPool connectionPool) throws DatabaseException {
        return ItemMapper.getItemByID(ID, connectionPool);
    }
}
