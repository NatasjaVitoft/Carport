package dat.backend.model.persistence;

import dat.backend.control.Item;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class ItemFacade {


    public static ArrayList<Item> itemList(ConnectionPool connectionPool) throws DatabaseException {

        return ItemMapper.getItemList(connectionPool);

    }
}
