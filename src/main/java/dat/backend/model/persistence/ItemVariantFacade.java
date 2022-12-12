package dat.backend.model.persistence;

import dat.backend.model.entities.ItemVariant;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class ItemVariantFacade {

    public static ArrayList<ItemVariant> itemVariantList(ConnectionPool connectionPool) throws DatabaseException {
        return ItemVariantMapper.ItemVariantList(connectionPool);
    }
}
